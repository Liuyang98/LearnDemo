package com.liqudel.learndemo.ui.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RelativeLayout;

public class AnimTextView extends AppCompatTextView {
    private static final String TAG = "AnimTextView";
    public AnimTextView(Context context) {
        super(context);
    }

    public AnimTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AnimTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private int marginLeft;

    public int getMarginLeft() {
        Log.e(TAG, "getMarginLeft: " );
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        return layoutParams.leftMargin;
    }

    public void setMarginLeft(int marginLeft) {
        Log.e(TAG, "setMarginLeft: ");
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        layoutParams.setMargins(marginLeft, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
        setLayoutParams(layoutParams);
    }
}
