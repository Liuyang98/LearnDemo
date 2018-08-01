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

        valueTest();
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
        Log.e(TAG, "swap: "+ a );
        ValueSendBean temp;
        temp = bean1;
        bean1 = bean2;
        bean2 = temp;

    }

}

