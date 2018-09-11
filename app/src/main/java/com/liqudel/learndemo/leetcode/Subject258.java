package com.liqudel.learndemo.leetcode;

import android.util.Log;

/**
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 * <p>
 * 示例:
 * <p>
 * 输入: 38
 * 输出: 2
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 * 进阶:
 * 你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
 */
public class Subject258 implements Subjcet {
    private static final String TAG = "Subject258";

    @Override
    public void run() {

        int n = addDigits(38);
        Log.e(TAG, "run: " + n);

    }

    public int addDigits(int num) {
        if (num == 0)
            return 0;
        int n = num % 9;
        return n == 0 ? 9 : n;

    }
}
