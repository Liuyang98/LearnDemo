package com.liqudel.learndemo.leetcode;

import android.util.Log;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class Subject283 implements Subjcet {
    private static final String TAG = "Subject283";


    public void moveZeroes(int[] nums) {
        int length = nums.length;

        int count = 0;
        int index = 0;

        for(int i=0;i<length;i++){
            if(nums[i]==0){
                count++;
            }else {
                nums[index]=nums[i];
                index++;
            }
        }

        for(int i=length-count;i<length;i++){
            nums[i]=0;
        }
    }


    private void swap(int[] ints, int a, int b) {
        int t = ints[a];
        ints[a] = ints[b];
        ints[b] = t;
    }


    @Override
    public void run() {
        int[] ints = new int[]{1, 3, 12, 0, 0, 4, 3, 4, 7, 8, 0, 0};
        moveZeroes(ints);

        StringBuilder sb = new StringBuilder();
        for (int n : ints) {
            sb.append(n + " , ");
        }
        Log.e(TAG, "数字 : " + sb);

    }
}
