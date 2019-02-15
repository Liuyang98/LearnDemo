package com.liqudel.learndemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.liqudel.learndemo.R;
import com.liqudel.learndemo.adapter.SampleRecyclerAdapter;
import com.liqudel.learndemo.sort.HeapSort;
import com.liqudel.learndemo.sort.QuickSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yangl.liu on 2018/3/7.
 */
public class AlgorithmFragment extends BaseFragment {
    private static final String TAG = "AlgorithmFragment";
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
        mDatas = Arrays.asList("快速排序", "堆排序", "二分查找", "算法4", "算法5");
    }

    private void initRecy() {
        rv.setLayoutManager(new LinearLayoutManager(mContext));
        rv.setAdapter(new SampleRecyclerAdapter(mContext, mDatas));
    }
}