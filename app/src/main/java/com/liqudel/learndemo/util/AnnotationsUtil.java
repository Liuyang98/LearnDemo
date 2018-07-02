package com.liqudel.learndemo.util;

import android.support.annotation.DrawableRes;
import android.support.annotation.IntDef;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class AnnotationsUtil {
    //使用注解代替枚举
    public static final int SUNDAY = 0;
    public static final int MONDAY = 1;
    public static final int TUESDAY = 2;
    public static final int WEDNESDAY = 3;

    @IntDef({SUNDAY, MONDAY, TUESDAY, WEDNESDAY})
    @Retention(RetentionPolicy.SOURCE)//指定注解只存在源码中
    public @interface WeekDays {
    }

    @WeekDays
    int currentDay = SUNDAY;

    public AnnotationsUtil() {
    }

    /**
     * 参数只能传入在声明范围内的整型，不然编译通不过
     *
     * @param currentDay
     */
    public void setCurrentDay(@WeekDays int currentDay) {
        this.currentDay = currentDay;
    }

    @WeekDays
    public int getCurrentDay() {
        return currentDay;
    }


    //用来标示特定的参数或返回值可以为Null
    public int getDay(@Nullable String str){
        return Integer.parseInt(str);
    }

    //Resource Type 注解 检查资源类型
    public void setImageRes(@DrawableRes int drawableId){

    }

    //限定方法执行的线程
    @MainThread
    public void clearCache(){

    }

}
