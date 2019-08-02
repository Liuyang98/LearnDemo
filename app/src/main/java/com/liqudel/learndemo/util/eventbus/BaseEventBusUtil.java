package com.liqudel.learndemo.util.eventbus;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class BaseEventBusUtil {

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void workDo(WorkEvent event) {
        Log.e("EventBus_WorkEvent", "工作");
    }

}

