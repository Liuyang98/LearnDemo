package com.liqudel.learndemo.activity

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.widget.RelativeLayout

import com.liqudel.learndemo.R
import com.liqudel.learndemo.bean.StepBean
import com.liqudel.learndemo.ui.widget.AnimTextView

import java.util.ArrayList
import java.util.Collections

 class QuickSortActivity : AppCompatActivity(), View.OnClickListener {
    private var numsRlayout: RelativeLayout? = null
    private var textViews: MutableList<AnimTextView>? = null
    private var arr: IntArray? = null
    private var stepList: MutableList<StepBean>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sort_quick)
        init()
        initView()
    }

    private fun init() {
        findViewById<View>(R.id.btn_crate_random).setOnClickListener(this)
        findViewById<View>(R.id.btn_quick_sort).setOnClickListener(this)

        numsRlayout = findViewById(R.id.rlayout_nums)
        textViews = ArrayList()
        stepList = ArrayList()
    }

    private fun initView() {
        textViews!!.clear()
        stepList!!.clear()
        numsRlayout!!.removeAllViews()
        arr = IntArray(7)
        for (i in 0..6) {
            val textView = AnimTextView(this)
            textView.setOnClickListener(this)
            val lp = RelativeLayout.LayoutParams(90, 90)
            textView.layoutParams = lp
            lp.setMargins(i * MAGIN_VALUE as Int, 0, 0, 0)
            val random = (100 * Math.random()).toInt()
            arr!![i] = random
            textView.text = random.toString() + ""
            textView.gravity = Gravity.CENTER
            textView.setTextColor(-0x1000000)
            textView.setBackgroundColor(-0x202021)
            numsRlayout!!.addView(textView)
            textViews!!.add(textView)
        }
        sort(arr!!)
    }

    private fun moveAnim(l: Int, r: Int) {
        startAnim(textViews!![l], r - l)
        startAnim(textViews!![r], l - r)

        numsRlayout!!.postDelayed({
            Collections.swap(textViews!!, l, r)
            if (!stepList!!.isEmpty()) {
                val stepBean = stepList!!.removeAt(0)
                moveAnim(stepBean.oldPoi, stepBean.newPoi)
            }
        }, 2000)
    }

    private fun startAnim(tv: AnimTextView, distance: Int) {
        val rtranslationX = ObjectAnimator.ofFloat(tv, "translationY", 0F, MAGIN_VALUE)
        val rtranslationY = ObjectAnimator.ofInt(tv, "marginLeft", tv.marginLeft, tv.marginLeft + distance * MAGIN_VALUE as Int)
        val rtranslationX2 = ObjectAnimator.ofFloat(tv, "translationY", MAGIN_VALUE, 0F)
        val rAnimatorSet = AnimatorSet()  //组合动画
        rAnimatorSet.playSequentially(rtranslationX, rtranslationY, rtranslationX2) //设置动画
        rAnimatorSet.duration = 666  //设置动画时间
        rAnimatorSet.start() //启动
    }


    fun sort(a: IntArray) {
        qsort(a, 0, a.size - 1)
    }

    private fun qsort(a: IntArray, i: Int, j: Int) {
        val pivot: Int
        if (i < j) {
            pivot = partition(a, i, j)  //  将a[] 一分为二，算出枢轴值pivot

            qsort(a, i, pivot - 1)   //  对低子表递归排序
            qsort(a, pivot + 1, j)   //  对高子表递归排序
        }
    }

    private fun partition(a: IntArray, i: Int, j: Int): Int {
        var i = i
        var j = j
        val pivotkey = a[i]   /* 用子表的第一个记录作枢轴记录 */
        while (i < j) {
            while (i < j && a[j] >= pivotkey)
            //从右往左，找比枢轴小的值
                j--
            swap(a, i, j)
            while (i < j && a[i] <= pivotkey)
            //从左往右，找比枢轴大的值
                i++
            swap(a, i, j)
        }
        return i
    }

    //交换位置
    private fun swap(a: IntArray, low: Int, high: Int) {
        if (low != high) {
            stepList!!.add(StepBean(low, high))
        }
        val k = a[low]
        a[low] = a[high]
        a[high] = k
    }

    private fun startAnim() {
        if (!stepList!!.isEmpty()) {
            val stepBean = stepList!!.removeAt(0)
            moveAnim(stepBean.oldPoi, stepBean.newPoi)
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_crate_random -> initView()
            R.id.btn_quick_sort -> startAnim()
            else -> {
            }
        }
    }

    companion object {
        private const val MAGIN_VALUE = 150F
    }
}
