package com.liqudel.learndemo.util.eventbus;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * 注册事件时，也会去查找父类中的注册事件
 * 发送子类事件时，同时也会触发父类事件
 */
public class EventBusUtil extends BaseEventBusUtil {


    public EventBusUtil() {
        init();
    }

    private void init() {
        EventBus.getDefault().register(this);
    }

    public void sendEvent(String text) {
        EventBus.getDefault().post(new ChildEvent(text));
        EventBus.getDefault().post(new WorkEvent());
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void childChange(ChildEvent event) {
        Log.e("EventBus_ShildEvent", event.getText());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void parentChange(ParentEvent event) {
        Log.e("EventBus_ParentEvent", event.getText());
    }
}

