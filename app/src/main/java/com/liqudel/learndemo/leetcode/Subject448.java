package com.liqudel.learndemo.leetcode;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * 示例:
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * 输出:
 * [5,6]
 */
public class Subject448 implements Subjcet {
    private static final String TAG = "Subject448";

    @Override
    public void run() {
        List list = findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});

        Log.e(TAG, "run: " + Arrays.toString(list.toArray()));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList();
        int[] n = new int[nums.length];
        for (int i : nums) n[i - 1] = 1;
        for (int i = 0; i < n.length; i++)
            if (n[i] != 1) list.add(i + 1);
        return list;
    }
}
