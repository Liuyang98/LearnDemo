package com.liqudel.learndemo.util;

import android.support.annotation.DrawableRes;
import android.support.annotation.IntDef;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 注解类使用，还需要整更多注解方式，了解注解的原理以及使用
 *
 * 元注解有
 *  Retention  保留期  （ 源码阶段，编译期，运行时 ）
 *  Documented 使注解元素包含到JavaDoc
 *  Target     注解运用到地方 （ 注解，构造方法，属性，局部变量，方法，包，方法内参数，类，接口 ）
 *  Inherited  使子类继承父类的注解
 *  Repeatable 可重复
 */
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
