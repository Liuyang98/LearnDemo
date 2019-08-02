package com.liqudel.learndemo.config;

import android.app.Application;
import android.content.Context;

import com.liqudel.learndemo.MyEventBusIndex;

import org.greenrobot.eventbus.EventBus;

public class LearnApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
        initEventBusIndex();
    }

    private void init() {
        context=this;
    }

    /**
     * EventBus提供了一个EventBusAnnotationProcessor注解处理器来在编译期通过读取@Subscribe注解，
     * 并解析和处理其中所包含的信息，然后生成java类来保存订阅者中所有的事件响应函数，
     * 这样就比在运行时使用反射来获得订阅者中所有事件响应函数的速度要快。
     *
     */
    private void initEventBusIndex() {
        EventBus.builder().addIndex(new MyEventBusIndex()).installDefaultEventBus();
    }

    public static Context getContext() {
        return context;
    }
}
