package com.liqudel.learndemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.liqudel.learndemo.BookController;

import java.util.ArrayList;
import java.util.List;

public class AIDLService extends Service {
    private static final String TAG = "AIDLService";

    private List<String> bookList;

    public AIDLService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        bookList = new ArrayList<>();
        initData();
    }

    private void initData() {
        bookList.add("活着");
        bookList.add("或者");
        bookList.add("叶应是叶");
        bookList.add("https://github.com/leavesC");
        bookList.add("http://www.jianshu.com/u/9df45b87cfdf");
        bookList.add("http://blog.csdn.net/new_one_object");
    }

    private final BookController.Stub stub = new BookController.Stub() {
        @Override
        public List<String> getBookList() throws RemoteException {
            return bookList;
        }

        @Override
        public void addBookInOut(String book) throws RemoteException {
            if (book != null) {
                Log.e(TAG, "addBookInOut: " + book);
                bookList.add(book);
            } else {
                Log.e(TAG, "addBookInOut: book is Null");
            }

        }
    };


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return stub;
    }
}
