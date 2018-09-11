package com.liqudel.learndemo.leetcode;

import android.util.Log;

/**
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * 示例 1:
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 */
public class Subject268 implements Subjcet {
    private static final String TAG = "Subject268";

    @Override
    public void run() {
        int n = missingNumber(new int[]{3, 0, 1, 5, 4, 2});
        Log.e(TAG, "run: " + n);
    }

    public int missingNumber(int[] nums) {
        int max = nums.length;
        int sum = (max + 1) * (max / 2);
        if (max % 2 == 1) sum += (max + 1) / 2;
        for (int i : nums) sum -= i;
        return sum;
    }

}
