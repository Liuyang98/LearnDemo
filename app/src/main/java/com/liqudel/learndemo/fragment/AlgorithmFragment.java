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
        quickSort(a);
        Log.e(TAG, "::: "+Arrays.toString(a));
    }


    //快速排序
    public void quickSort(int a[]) {
        QSort(a, 0, a.length - 1);
    }

    void QSort(int a[], int i, int j) {
        int pivot;
        if (i < j) {
            pivot = Partition(a, i, j); //  将a[] 一分为二，算出枢轴值pivot

            QSort(a, i, pivot - 1);   //  对低子表递归排序
            QSort(a, pivot + 1, j);   //  对高子表递归排序
        }
    }

    int Partition(int a[], int i, int j) {
        int pivotkey;
        pivotkey = a[i];  /* 用子表的第一个记录作枢轴记录 */
        while (i < j) {
            while (i < j && a[j] >= pivotkey)//从右往左，找比枢轴小的值
                j--;
            swap(a, i, j);
            while (i < j && a[i] <= pivotkey)//从左往右，找比枢轴大的值
                i++;
            swap(a, i, j);

        }
        return i;
    }

    //交换位置
    private void swap(int[] a, int low, int high) {
        int k = a[low];
        a[low] = a[high];
        a[high] = k;
    }

}