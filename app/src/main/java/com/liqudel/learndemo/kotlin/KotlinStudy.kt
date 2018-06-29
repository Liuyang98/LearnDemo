package com.example.liuyang.learn.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.liqudel.learndemo.R


class KotlinStudy : AppCompatActivity() {

    //变量
    var a:Int =1
    //常量
    val b=1
    //系统推断变量类型为Int
    var x= 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        vars(4,2,1,5,6,8)

        var age:String? ="23"
        val ages = age!!.toInt()
    }


    //函数定义
    fun sum(a: Int ,b: Int ):Int{
        return a + b
    }

    //函数定义（无参）
    fun printSum(a: Int ,b:Int ){
        print(a+b)
    }

    //可变长参数函数
    fun vars(vararg v:Int){
        for(vt in v){
            print(vt)
        }
    }

    //当str中字符串内容不是一个整数时，返回null
    fun parseInt(str:String):Int ?{
        return Integer.parseInt(str)
    }

    //可以使用is运算符检测一个表达式是否某类型的一个实例
    fun getStringLength(obj :Any):Int?{
        if(obj is String){
            return obj.length
        }
        return null
    }

    //或者
    fun getStringLength2(obj :Any):Int?{
        if(obj !is String)
            return null
        //在这个分支中，obj类型会被自动转换为 String
        return obj.length
    }

    //区间用法 （1-10）
    fun qujian(){
        var i:Int
        for(i in 1..10){
            print(i)
        }
    }

}
