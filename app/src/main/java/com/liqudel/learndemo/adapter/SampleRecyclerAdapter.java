package com.liqudel.learndemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liqudel.learndemo.R;
import com.liqudel.learndemo.activity.ConstraintActivity;
import com.liqudel.learndemo.activity.CustomBehaviorActivity;
import com.liqudel.learndemo.activity.EasyBehaviorActivity;
import com.liqudel.learndemo.activity.QuickSortActivity;
import com.liqudel.learndemo.activity.RxJavaActivity;

import java.util.List;

/**
 * Created by yangl.liu on 2018/6/29.
 */
public class SampleRecyclerAdapter extends BaseRecyclerAdapter<SampleRecyclerAdapter.SimHolder> implements View.OnClickListener {
    private List<String> mDatas;

    public SampleRecyclerAdapter(Context mContext, List mDatas) {
        super(mContext, mDatas);
        this.mDatas = mDatas;
    }

    @Override
    public SimHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SimHolder(initView(parent, R.layout.item_sample));
    }

    @Override
    public void onBindViewHolder(SimHolder viewHolder, int position) {
        viewHolder.textView.setText(mDatas.get(position));
        viewHolder.textView.setTag("" + position);
    }

    @Override
    public void onClick(View view) {
        String tag = "" + view.getTag();
        switch (tag) {
            case "0":
                mContext.startActivity(new Intent(mContext, ConstraintActivity.class));
                break;
            case "1":
                mContext.startActivity(new Intent(mContext, EasyBehaviorActivity.class));
                break;
            case "2":
                mContext.startActivity(new Intent(mContext, CustomBehaviorActivity.class));
                break;
            case "3":
                mContext.startActivity(new Intent(mContext, RxJavaActivity.class));
                break;
            case "4":
//                mContext.startActivity(new Intent(mContext, QuickSortActivity.class));
                break;
            default:
                break;
        }
    }

    class SimHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public SimHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_item);
            textView.setOnClickListener(SampleRecyclerAdapter.this);
        }
    }

}