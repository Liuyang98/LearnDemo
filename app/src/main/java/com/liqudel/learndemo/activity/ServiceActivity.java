package com.liqudel.learndemo.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.liqudel.learndemo.BookController;

import java.util.List;

public class ServiceActivity extends AppCompatActivity {
    private static final String TAG = "ServiceActivity";

    private BookController bookController;

    private boolean connected;

    private List<String> bookList;


    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            bookController = BookController.Stub.asInterface(service);
            connected = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            connected = false;
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bindMyService();
    }

    private void bindMyService() {
        Intent intent = new Intent();
        intent.setPackage("com.liqudel.learndemo");
        intent.setAction("com.liqudel.learndemo.service");
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    private void getBookList() {
        Log.e(TAG, "getBookList: ");
        try {
            bookList = bookController.getBookList();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private void addBook() {
        Log.e(TAG, "addBook: ");
        String nBook = "新书";
        try {
            bookController.addBookInOut(nBook);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


}
