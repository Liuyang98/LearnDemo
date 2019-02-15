package com.liqudel.learndemo.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.liqudel.learndemo.R;
import com.liqudel.learndemo.bean.StepBean;
import com.liqudel.learndemo.ui.widget.AnimTextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuickSortActivity extends AppCompatActivity implements View.OnClickListener {
    private RelativeLayout numsRlayout;
    private List<AnimTextView> textViews;
    private static final int MAGIN_VALUE = 150;
    private int arr[];
    private List<StepBean> stepList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort_quick);
        init();
        initView();
    }

    private void init() {
        findViewById(R.id.btn_crate_random).setOnClickListener(this);
        findViewById(R.id.btn_quick_sort).setOnClickListener(this);

        numsRlayout = findViewById(R.id.rlayout_nums);
        textViews = new ArrayList<>();
        stepList = new ArrayList<>();
    }

    private void initView() {
        textViews.clear();
        stepList.clear();
        numsRlayout.removeAllViews();
        arr = new int[7];
        for (int i = 0; i < 7; i++) {
            AnimTextView textView = new AnimTextView(this);
            textView.setOnClickListener(this);
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(90, 90);
            textView.setLayoutParams(lp);
            lp.setMargins(i * MAGIN_VALUE, 0, 0, 0);
            int random = (int) (100 * Math.random());
            arr[i] = random;
            textView.setText(random + "");
            textView.setGravity(Gravity.CENTER);
            textView.setTextColor(0xff000000);
            textView.setBackgroundColor(0xffdfdfdf);
            numsRlayout.addView(textView);
            textViews.add(textView);
        }
        sort(arr);
    }

    private void moveAnim(final int l, final int r) {
        Log.e("删除", "l : " + l + "  r : " + r);
        final AnimTextView lTv = textViews.get(l);
        AnimTextView rTv = textViews.get(r);
        ObjectAnimator ltranslationX = new ObjectAnimator().ofFloat(lTv, "translationY", 0, MAGIN_VALUE);
        Toast.makeText(this, "(r - l)" + (r - l), Toast.LENGTH_SHORT).show();
        ObjectAnimator ltranslationY = new ObjectAnimator().ofInt(lTv, "marginLeft", lTv.getMarginLeft(), lTv.getMarginLeft() + (r - l) * MAGIN_VALUE);
        ObjectAnimator ltranslationX2 = new ObjectAnimator().ofFloat(lTv, "translationY", MAGIN_VALUE, 0);

        AnimatorSet animatorSet = new AnimatorSet();  //组合动画
        animatorSet.playSequentially(ltranslationX, ltranslationY, ltranslationX2); //设置动画
        animatorSet.setDuration(1000);  //设置动画时间
        animatorSet.start(); //启动
        ObjectAnimator rtranslationX = new ObjectAnimator().ofFloat(rTv, "translationY", 0, MAGIN_VALUE);
        ObjectAnimator rtranslationY = new ObjectAnimator().ofInt(rTv, "marginLeft", rTv.getMarginLeft(), rTv.getMarginLeft() + (r - l) * -MAGIN_VALUE);
        ObjectAnimator rtranslationX2 = new ObjectAnimator().ofFloat(rTv, "translationY", MAGIN_VALUE, 0);

        AnimatorSet rAnimatorSet = new AnimatorSet();  //组合动画
        rAnimatorSet.playSequentially(rtranslationX, rtranslationY, rtranslationX2); //设置动画
        rAnimatorSet.setDuration(1000);  //设置动画时间
        rAnimatorSet.start(); //启动

        lTv.postDelayed(new Runnable() {
            @Override
            public void run() {
                Collections.swap(textViews, l, r);
                if (!stepList.isEmpty()) {
                    StepBean stepBean = stepList.remove(0);
                    moveAnim(stepBean.getOldPoi(), stepBean.getNewPoi());
                }
            }
        }, 3000);
    }


    public void sort(int[] a) {
        qsort(a, 0, a.length - 1);
    }

    private void qsort(int a[], int i, int j) {
        int pivot;
        if (i < j) {
            pivot = partition(a, i, j);  //  将a[] 一分为二，算出枢轴值pivot

            qsort(a, i, pivot - 1);   //  对低子表递归排序
            qsort(a, pivot + 1, j);   //  对高子表递归排序
        }
    }

    private int partition(int a[], int i, int j) {
        int pivotkey = a[i];   /* 用子表的第一个记录作枢轴记录 */
        while (i < j) {
            while (i < j && a[j] >= pivotkey) //从右往左，找比枢轴小的值
                j--;
            swap(a, i, j);
            while (i < j && a[i] <= pivotkey)//从左往右，找比枢轴大的值
                i++;
            swap(a, i, j);
        }
        return i;
    }

    //交换位置
    private void swap(int[] a, int low, int high) {
        if (low != high) {
            stepList.add(new StepBean(low, high));
        }
        int k = a[low];
        a[low] = a[high];
        a[high] = k;
    }

    private void startAnim() {
//        StepBean stepBean = stepList.remove(0);
//        if (stepBean != null) {
//            moveAnim(stepBean.getOldPoi(), stepBean.getNewPoi());
//        }

        if (!stepList.isEmpty()) {
            StepBean stepBean = stepList.remove(0);
            moveAnim(stepBean.getOldPoi(), stepBean.getNewPoi());
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_crate_random:
                initView();
                break;
            case R.id.btn_quick_sort:
//                moveAnim(3, 6);
                startAnim();
                break;
            default:
                Toast.makeText(this, "" + ((TextView) v).getText(), Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
