package com.liqudel.learndemo.activity;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.liqudel.learndemo.R;
import com.liqudel.learndemo.bean.Course;
import com.liqudel.learndemo.bean.Student;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


public class RxJavaActivity extends AppCompatActivity {
    private static final String TAG = "RxJavaActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.e(TAG, "onCreate: ");
//        normal();
//        arrayMothod();
//        loadPic();
//        map();
//        mapArray();
        flatMap();
        lift();
    }

    private void lift() {

    }

    private void normal() {
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("消息1");
                subscriber.onNext("消息2");
                subscriber.onNext("消息3");
                subscriber.onCompleted();
            }
        });

        Observer observer = new Observer<String>() {

            @Override
            public void onNext(String s) {
                Log.e(TAG, ':' + s);
            }

            @Override
            public void onCompleted() {
                Log.e(TAG, "onComplete: ");

            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: ");
            }

        };
        observable.subscribe(observer);
    }

    private void arrayMothod() {
        Observable.just(1, 2, 3, 4)
                .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
                .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        Log.e(TAG, "integer:" + integer);
                    }
                });

    }

    /**
     * 加载图片在IO线程，图片设置在主线程
     */
    private void loadPic() {
        final int drawableRes = -1;
        final ImageView imageView = new ImageView(this);
        Observable.create(new Observable.OnSubscribe<Drawable>() {
            @Override
            public void call(Subscriber<? super Drawable> subscriber) {
                Drawable drawable = getResources().getDrawable(drawableRes);
                subscriber.onNext(drawable);
                subscriber.onCompleted();
            }
        })
                .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
                .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
                .subscribe(new Observer<Drawable>() {
                    public void onNext(Drawable drawable) {
                        imageView.setImageDrawable(drawable);
                    }


                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(RxJavaActivity.this, "Error!", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void map() {

        Observable.just("images/logo.png") // 输入类型 String
                .map(new Func1<String, Bitmap>() {
                    @Override
                    public Bitmap call(String filePath) { // 参数类型 String
                        return getBitmapFromPath(filePath); // 返回类型 Bitmap
                    }
                })
                .subscribe(new Action1<Bitmap>() {
                    @Override
                    public void call(Bitmap bitmap) { // 参数类型 Bitmap
                        showBitmap(bitmap);
                    }
                });
    }

    private Bitmap getBitmapFromPath(String filePath) {
        Bitmap bitmap = Bitmap.createBitmap(R.drawable.ic_launcher_background, 100, Bitmap.Config.ARGB_8888);
        return bitmap;
    }

    private void showBitmap(Bitmap bitmap) {

    }

    private void mapArray() {
        Student[] students = new Student[3];
        students[0] = new Student("小明");
        students[1] = new Student("小红");
        students[2] = new Student("小兰");

        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                Log.e(TAG, "onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: " );
            }

            @Override
            public void onNext(String name) {
                Log.e(TAG, name);
            }
        };
        Observable.from(students)
                .map(new Func1<Student, String>() {
                    @Override
                    public String call(Student student) {
                        return student.getName();
                    }
                })
                .subscribe(subscriber);
    }



    private void flatMap() {
        Student[] students = new Student[3];
        students[0] = new Student("小明");
        students[1] = new Student("小红");
        students[2] = new Student("小兰");

        Subscriber<Course> subscriber = new Subscriber<Course>() {
            @Override
            public void onCompleted() {
                Log.e(TAG, "onCompleted: " );
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: " );
            }

            @Override
            public void onNext(Course course) {
                Log.e(TAG, course.getName());
            }
        };

        Observable.from(students)
                .flatMap(new Func1<Student, Observable<Course>>() {
                    @Override
                    public Observable<Course> call(Student student) {
                        return Observable.from(student.getCourses());
                    }
                })
                .subscribe(subscriber);
    }

}
