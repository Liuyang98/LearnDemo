package com.liqudel.learndemo.leetcode;


import android.util.Log;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * 解法：由于其他元素均出现两次，所以可以用 ^ (异或)的原理处理
 */
public class Subject136 implements Subjcet {
    private static final String TAG = "Subject136";

    @Override
    public void run() {
        int n = singleNumber(new int[]{2, 2, 1,4,5,5,4,1,8,6,6});
        Log.e(TAG, "run: " +n );
    }

    public int singleNumber(int[] nums) {
        int value = 0;
        for (int num : nums) {
            value = value ^ num;
        }
        return value;
    }
}
