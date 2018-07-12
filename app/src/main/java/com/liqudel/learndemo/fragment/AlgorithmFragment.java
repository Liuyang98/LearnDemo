package com.liqudel.learndemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liqudel.learndemo.R;
import com.liqudel.learndemo.adapter.SampleRecyclerAdapter;
import com.liqudel.learndemo.sort.HeapSort;

import java.util.ArrayList;
import java.util.Arrays;
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
            initAlgorithm();
        }
        return rv;
    }

    private void init() {
        mDatas = new ArrayList<>();
        mDatas.add("算法1");
        mDatas.add("算法2");
        mDatas.add("算法3");
        mDatas.add("算法4");
        mDatas.add("算法5");
    }

    private void initRecy() {
        rv.setLayoutManager(new LinearLayoutManager(mContext));
        rv.setAdapter(new SampleRecyclerAdapter(mContext, mDatas));
    }


    private void initAlgorithm() {
        int a[] = {42, 38, 45, 50, 47, 13, 27, 42};
//        new QuickSort().sort(a);
        new HeapSort().sort(a);
        Log.e(TAG, ":: " + Arrays.toString(a));
    }

}