package com.liqudel.learndemo.leetcode;


import android.util.Log;

/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * 示例 1:
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class Subject169 implements Subjcet {
    private static final String TAG = "Subject169";

    @Override
    public void run() {
        int n = majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
        Log.e(TAG, "运算结果: " + n);
    }


    //原理：由于众数个数>n/2，且题目限制众数一定存在，所以只要找到不同的两个数就消掉，最后剩下的一定就是众数
    public int majorityElement(int[] nums) {
        int main = nums[0]; // 用于记录主元素，假设第一个是主元素
        int count = 1; // 用于抵消数的个数

        for (int i = 1; i < nums.length; i++) { // 从第二个元素开始到最后一个元素
            if (main == nums[i]) { // 如果两个数相同就不能抵消
                count++; // 用于抵消的数据加1
            } else {
                if (count > 0) { // 如果不相同，并且有可以抵消的数
                    count--; // 进行数据抵消
                } else { // 如果不相同，并且没有可以抵消的数
                    main = nums[i]; // 记录最后不可以抵消的数

                    Log.e(TAG, "majorityElement:   main = nums[i]; "+nums);
                }
            }
        }
        return main;

    }
}
