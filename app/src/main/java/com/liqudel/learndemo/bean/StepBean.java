package com.liqudel.learndemo.bean;

import android.util.Log;

public class StepBean {
    private int oldPoi;
    private int newPoi;

    public StepBean(int oldPoi, int newPoi) {
        this.oldPoi = oldPoi;
        this.newPoi = newPoi;
        Log.e("步骤", "oldPoi: "+oldPoi +" ： newPoi ："+newPoi );
    }

    public int getOldPoi() {
        return oldPoi;
    }

    public int getNewPoi() {
        return newPoi;
    }
}
