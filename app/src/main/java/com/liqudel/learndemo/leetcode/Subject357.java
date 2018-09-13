package com.liqudel.learndemo.leetcode;


import android.util.Log;

/**
 * 给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。
 * 示例:
 * 输入: 2
 * 输出: 91
 * 解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
 */
public class Subject357 implements Subjcet {
    private static final String TAG = "Subject357";

    @Override
    public void run() {

        int n = countNumbersWithUniqueDigits(4);
        Log.e(TAG, "run:  " + n);
    }

    public int countNumbersWithUniqueDigits(int n) {
        //dp[i] 表示的是位数为 i 的 X 的数量，即G（n）
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int result = 1;
        for (int i = 1; i <= n; i++) {
            if (i == 1) dp[i] = 9;
            else dp[i] = dp[i - 1] * (11 - i);
            result += dp[i];
        }
        return result;
    }

}
