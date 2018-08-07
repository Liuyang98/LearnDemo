package com.liqudel.learndemo.proxy;


import android.util.Log;

public class RealSubject implements Subject {
    private static final String TAG = "RealSubject";

    @Override
    public void rent() {
        Log.e(TAG, "rent: ");
    }

    @Override
    public void hello(String str) {
        Log.e(TAG, "hello: ");
    }
}
