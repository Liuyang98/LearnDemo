package com.liqudel.learndemo.leetcode;


import android.util.Log;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 * <p>
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */
public class Subject198 implements Subjcet {
    private static final String TAG = "Subject198";

    @Override
    public void run() {
        int n = rob(new int[]{1, 2, 3, 4});
        Log.e(TAG, "run: " + n);
    }

    private int rob(int[] nums) {
        int p[] = new int[nums.length];
        p[0] = nums[0];
        p[1] = nums[1];


//        for (int i = 2; i < nums.length; i++) {
//
//
//
//            int max = Math.max(nums[i - 1], nums[i - 2]);
//            p[i] = nums[i] + max;
//            Log.e(TAG, "i   ：" + i + "  p[i] ：：" + p[i]);
//        }

        int index=-1;
        while (index<nums.length){


        }



        return p[p.length - 1];
    }
}
