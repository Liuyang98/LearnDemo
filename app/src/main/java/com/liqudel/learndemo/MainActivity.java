package com.liqudel.learndemo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.liqudel.learndemo.adapter.SamplePagerAdapter;
import com.liqudel.learndemo.bean.ValueSendBean;
import com.liqudel.learndemo.fragment.AlgorithmFragment;
import com.liqudel.learndemo.fragment.SimpleFragment;
import com.liqudel.learndemo.leetcode.Subject121;
import com.liqudel.learndemo.leetcode.Subject136;
import com.liqudel.learndemo.leetcode.Subject169;
import com.liqudel.learndemo.leetcode.Subject191;
import com.liqudel.learndemo.proxy.DynamicProxy;
import com.liqudel.learndemo.proxy.RealSubject;
import com.liqudel.learndemo.proxy.Subject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ViewPager vp;
    private TabLayout tabLayout;
    private List<Fragment> fragmentList;
    private List<String> titleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initViewPager();
        //数据结构-算法
    }

    private void init() {
        vp = findViewById(R.id.vp);
        tabLayout = findViewById(R.id.tablayout);
        fragmentList = new ArrayList<>();
        titleList = new ArrayList<>();


//        valueTest();
//        proxyTest();

     new Subject191().run();
    }


    private void proxyTest() {
        Subject realSubject = new RealSubject();

        // 我们要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法的
        InvocationHandler handler = new DynamicProxy(realSubject);
        /*
         * 通过Proxy的newProxyInstance方法来创建我们的代理对象，
         * 我们来看看其三个参数 第一个参数 handler.getClass().getClassLoader()
         * 我们这里使用handler这个类的ClassLoader对象来加载我们的代理对象
         * 第二个参数realSubject.getClass().getInterfaces()，我们这里为代理对象提供的接口是真实对象所实行的接口，
         * 表示我要代理的是该真实对象，这样我就能调用这组接口中的方法了
         * 第三个参数handler， 我们这里将这个代理对象关联到了上方的InvocationHandler这个对象上
         *
         */

        Subject subject = (Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(), realSubject.getClass().getInterfaces(), handler);

        Log.e(TAG, subject.getClass().getName());
        subject.rent();
        subject.hello("world");


    }

    private void initViewPager() {
        fragmentList.add(new SimpleFragment().setType(0));
        fragmentList.add(new AlgorithmFragment().setType(1));
        titleList.add("用例列表");
        titleList.add("算法");


        vp.setAdapter(new SamplePagerAdapter(getSupportFragmentManager(), fragmentList, titleList));
        tabLayout.setupWithViewPager(vp);
        vp.setVisibility(View.VISIBLE);

    }

    private void valueTest() {
        int a = 89;
        ValueSendBean bean = new ValueSendBean("first", 1);
        ValueSendBean bean2 = new ValueSendBean("second", 2);
        Log.e(TAG, "bean : " + bean.toString() + "  :  bean2 : " + bean2.toString() + " a : " + a);
        swap(bean, bean2, a);

        Log.e(TAG + " ;2;", "bean : " + bean.toString() + "  :  bean2 : " + bean2.toString() + " a : " + a);
    }

    private void swap(ValueSendBean bean1, ValueSendBean bean2, int a) {
        a++;
        Log.e(TAG, "swap: " + a);
        ValueSendBean temp;
        temp = bean1;
        bean1 = bean2;
        bean2 = temp;
    }

}

