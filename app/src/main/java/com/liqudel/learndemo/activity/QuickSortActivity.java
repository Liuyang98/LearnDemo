package com.liqudel.learndemo.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.liqudel.learndemo.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuickSortActivity extends AppCompatActivity implements View.OnClickListener {
    private RelativeLayout numsRlayout;
    private List<TextView> textViews;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort_quick);
        init();
        initView();
    }

    private void init() {
        findViewById(R.id.btn_crate_random).setOnClickListener(this);
        findViewById(R.id.btn_quick_sort).setOnClickListener(this);

        numsRlayout = findViewById(R.id.rlayout_nums);
        textViews = new ArrayList<>();
    }

    private void initView() {
        textViews.clear();
        numsRlayout.removeAllViews();

        for (int i = 0; i < 7; i++) {
            TextView textView = new TextView(this);
            textView.setOnClickListener(this);
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(90, 90);
            textView.setLayoutParams(lp);
            lp.setMargins(i * 150, 0, 0, 0);
            int random = (int) (100 * Math.random());
            textView.setText(random + "");
            textView.setGravity(Gravity.CENTER);
            textView.setTextColor(0xff000000);
            textView.setBackgroundColor(0xffdfdfdf);
            numsRlayout.addView(textView);
            textViews.add(textView);
        }
    }

    private void moveAnim(final int l, final int r) {
        final TextView lTv = textViews.get(l);
        TextView rTv = textViews.get(r);

        ObjectAnimator ltranslationX = new ObjectAnimator().ofFloat(lTv, "translationY", 0, 150);
        Toast.makeText(this, "(r - l)" + (r - l), Toast.LENGTH_SHORT).show();
        ObjectAnimator ltranslationY = new ObjectAnimator().ofFloat(lTv, "translationX", 0, (r - l) * 150);
        ObjectAnimator ltranslationX2 = new ObjectAnimator().ofFloat(lTv, "translationY", 150, 0);

        AnimatorSet animatorSet = new AnimatorSet();  //组合动画
        animatorSet.playSequentially(ltranslationX, ltranslationY, ltranslationX2); //设置动画
        animatorSet.setDuration(1000);  //设置动画时间
        animatorSet.start(); //启动

        ObjectAnimator rtranslationX = new ObjectAnimator().ofFloat(rTv, "translationY", 0, 150);
        ObjectAnimator rtranslationY = new ObjectAnimator().ofFloat(rTv, "translationX", 0, (r - l) * -150);
        ObjectAnimator rtranslationX2 = new ObjectAnimator().ofFloat(rTv, "translationY", 150, 0);

        AnimatorSet rAnimatorSet = new AnimatorSet();  //组合动画
        rAnimatorSet.playSequentially(rtranslationX, rtranslationY, rtranslationX2); //设置动画
        rAnimatorSet.setDuration(1000);  //设置动画时间
        rAnimatorSet.start(); //启动

        lTv.postDelayed(new Runnable() {
            @Override
            public void run() {
                Collections.swap(textViews,l,r);
            }
        }, 1000);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_quick_sort:
                moveAnim(3, 6);
                break;
            default:
                Toast.makeText(this, "" + ((TextView) v).getText(), Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
