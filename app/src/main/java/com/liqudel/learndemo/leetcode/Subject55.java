package com.liqudel.learndemo.leetcode;


import android.util.Log;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 * 示例 2:
 * <p>
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */
public class Subject55 implements Subjcet {
    private static final String TAG = "Subject55";

    @Override
    public void run() {
        boolean n = canJump(new int[]{1, 1, 0, 1});
//        boolean n = canJump(new int[]{2, 3, 1, 1, 4});
        Log.e(TAG, "run: " + n);
    }

    public boolean canJump(int[] nums) {
        int reach = nums[0];

        for (int i = 1; i < nums.length && reach >= i; i++) {

            if (reach < nums[i] + i) {
                reach = nums[i] + i;
            }


            Log.e(TAG, "canJump:  reach " + reach);
        }

        return reach >= nums.length - 1;
    }

}
