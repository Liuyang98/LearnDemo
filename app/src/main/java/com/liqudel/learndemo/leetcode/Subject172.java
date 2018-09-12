package com.liqudel.learndemo.leetcode;

import android.util.Log;

/**
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 * <p>
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 */
public class Subject172 implements Subjcet {
    private static final String TAG = "Subject172";

    @Override
    public void run() {
        int n = trailingZeroes(15);
        Log.e(TAG, "run: " + n);
    }


    // 5*2=10  25*4=100  125*8 = 1000
    int trailingZeroes(int n) {
        int sum = 0;
        while (n != 0)
            sum += (n /= 5);
        return sum;
    }
}
