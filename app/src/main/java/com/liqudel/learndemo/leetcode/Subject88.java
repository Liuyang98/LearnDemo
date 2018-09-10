package com.liqudel.learndemo.leetcode;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 */

public class Subject88 implements Subjcet {
    private static final String TAG = "Subject75";

    @Override
    public void run() {
        int[] aaa = new int[]{1, 2, 3, 0, 0, 0};
        int[] bbb = new int[]{2, 5, 6};
        merge(aaa, 3, bbb, 3);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len =m>n? nums1.length:nums2.length;

        for (int i = len- 1; i > 0; i--) {
            if (n == 0) {
                nums1[i] = nums1[--m];
                continue;
            }

            if (m == 0) {
                nums1[i] = nums2[--n];
                continue;
            }

            nums1[i] = nums1[m - 1] > nums2[n - 1] ? nums1[--m] : nums2[--n];
        }
    }
}
