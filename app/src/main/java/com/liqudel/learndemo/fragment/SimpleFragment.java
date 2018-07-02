package com.liqudel.learndemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liqudel.learndemo.R;
import com.liqudel.learndemo.adapter.SampleRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangl.liu on 2018/3/7.
 */

public class SimpleFragment extends BaseFragment {
    private RecyclerView rv;
    private List<String> mDatas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rv == null) {
            rv = (RecyclerView) inflater.inflate(R.layout.layout_only_recy, container, false);

            init();
            initRecy();
        }
        return rv;
    }

    private void init() {

        mDatas = new ArrayList<>();
        mDatas.add("Constraint约束布局");
        mDatas.add("Behavior_base");
        mDatas.add("Behavior_custom");
    }

    private void initRecy() {
        rv.setLayoutManager(new LinearLayoutManager(mContext));
        rv.setAdapter(new SampleRecyclerAdapter(mContext, mDatas));
    }
}


















