package com.liqudel.learndemo.leetcode;

import android.util.Log;

import java.util.Arrays;

/**
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: 6
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: 24
 * 注意:
 * <p>
 * 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
 * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 */
public class Subjcet628 implements Subjcet {
    private static final String TAG = "Subjcet628";

    @Override
    public void run() {
        int n = maximumProduct(new int[]{1, 2, 3, 4, 5});
        Log.e(TAG, "run: " + n);
    }


    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int a = nums[0] * nums[1] * nums[nums.length - 1];
        int b = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        return a > b ? a : b;
    }


}
