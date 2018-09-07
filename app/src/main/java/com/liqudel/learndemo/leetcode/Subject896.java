package com.liqudel.learndemo.leetcode;

import android.util.Log;

import java.util.Arrays;

/**
 * 如果数组是单调递增或单调递减的，那么它是单调的。
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
 * 示例 1：
 * 输入：[1,2,2,3]
 * 输出：true
 * 示例 2：
 * 输入：[6,5,4,4]
 * 输出：true
 * 示例 3：
 * 输入：[1,3,2]
 * 输出：false
 * 示例 4：
 * 输入：[1,2,4,5]
 * 输出：true
 * 示例 5：
 * 输入：[1,1,1]
 * 输出：true
 * 提示：
 * 1 <= A.length <= 50000
 * -100000 <= A[i] <= 100000
 */
public class Subject896 implements Subjcet {
    private static final String TAG = "Subject896";

    @Override
    public void run() {
        boolean bool = isMonotonic(new int[]{3, 2, 1});
        Log.e(TAG, "run: " + bool);
    }

    private boolean isMonotonic(int[] A) {
        int length = A.length;
        if (length < 2)
            return true;

        int[] B = new int[length];
        System.arraycopy(A, 0, B, 0, length);
        Arrays.sort(B);
        if (Arrays.equals(A, B)) {
            return true;
        }

        for (int i = 0; i < length; i++) {
            if (B[length - i - 1] != A[i])
                return false;
        }
        return true;
    }
}
