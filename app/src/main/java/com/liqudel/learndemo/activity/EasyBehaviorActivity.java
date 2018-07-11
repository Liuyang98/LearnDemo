package com.liqudel.learndemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.liqudel.learndemo.R;
import com.liqudel.learndemo.adapter.SampleRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class EasyBehaviorActivity extends AppCompatActivity {
    private RecyclerView rv;
    private List<String> mDatas;
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_behavior);

        init();
        initView();
    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        rv = findViewById(R.id.recyclerView);
        mDatas = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            mDatas.add("测试：：" + i);
        }
    }

    private void initView() {
        toolbar.setTitle("EasyBehavior");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        SampleRecyclerAdapter sampleRecyclerAdapter = new SampleRecyclerAdapter(this, mDatas);
        rv.setAdapter(sampleRecyclerAdapter);
    }

}