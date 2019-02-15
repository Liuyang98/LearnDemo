package com.liqudel.learndemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liqudel.learndemo.R;
import com.liqudel.learndemo.activity.ConstraintActivity;
import com.liqudel.learndemo.activity.CustomBehaviorActivity;
import com.liqudel.learndemo.activity.EasyBehaviorActivity;
import com.liqudel.learndemo.activity.QuickSortActivity;
import com.liqudel.learndemo.activity.RxJavaActivity;
import com.liqudel.learndemo.sort.BinarySearch;
import com.liqudel.learndemo.sort.HeapSort;
import com.liqudel.learndemo.sort.QuickSort;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yangl.liu on 2018/6/29.
 */
public class SampleRecyclerAdapter extends BaseRecyclerAdapter<SampleRecyclerAdapter.SimHolder> implements View.OnClickListener {
    private static final int ARRAY_COUNT_MIN = 6;
    private static final int ARRAY_COUNT_MAX = 10;

    public SampleRecyclerAdapter(Context mContext, List mDatas) {
        super(mContext, mDatas);
    }

    @Override
    public SimHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SimHolder(initView(parent, R.layout.item_sample));
    }

    @Override
    public void onBindViewHolder(SimHolder viewHolder, int position) {
        viewHolder.setPosition(position);
    }

    class SimHolder extends RecyclerView.ViewHolder {
        TextView textView;

        private SimHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_item);
            textView.setOnClickListener(SampleRecyclerAdapter.this);
        }

        private void setPosition(int position) {
            textView.setText(mDatas.get(position).toString());
        }
    }

    @Override
    public void onClick(View view) {
        String tag = ((TextView) view).getText().toString();
        switch (tag) {
            case "Constraint约束布局":
                mContext.startActivity(new Intent(mContext, ConstraintActivity.class));
                break;
            case "Behavior_base":
                mContext.startActivity(new Intent(mContext, EasyBehaviorActivity.class));
                break;
            case "Behavior_custom":
                mContext.startActivity(new Intent(mContext, CustomBehaviorActivity.class));
                break;
            case "RxJava 2.0":
                mContext.startActivity(new Intent(mContext, RxJavaActivity.class));
                break;
            case "QuickSort":
                mContext.startActivity(new Intent(mContext, QuickSortActivity.class));
                break;
            case "快速排序":
                initAlgorithm(tag);
                break;
            case "堆排序":
                initAlgorithm(tag);
                break;
            case "二分查找":
                initAlgorithm(tag);
                break;
            default:
                break;
        }
    }

    //生成数量不定定两位数随机数，并且通过UI操作， 把所有算法类都实现一个公共接口 implements
    private void initAlgorithm(String typeTag) {
        int a[] = createRandomArray();
        switch (typeTag) {
            case "快速排序":
                QuickSort.doSort(a);
                break;
            case "堆排序":
                HeapSort.doSort(a);
                break;
            case "二分查找":
                HeapSort.doSort(a);
                BinarySearch.doSearch(a);
                break;
            default:
                break;
        }
    }

    private int[] createRandomArray() {
        int count = (int) (ARRAY_COUNT_MIN + Math.random() * (ARRAY_COUNT_MAX - ARRAY_COUNT_MIN));
        int[] nArray = new int[count];
        for (int i = 0; i < count; i++) {
            nArray[i] = (int) (100 * Math.random());
        }
        Log.e("分割线", "-");
        Log.e("生成随机数: ", Arrays.toString(nArray));
        return nArray;
    }
}