package com.liqudel.learndemo.leetcode;

import android.util.Log;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * 示例:
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */


public class Subject64 implements Subjcet {
    private static final String TAG = "Subject64";

    @Override
    public void run() {
        int n = minPathSum(new int[][]{{1, 3, 1,}, {1, 5, 1}, {4, 2, 1}});
        Log.e(TAG, "run: " + n);
    }

    private int minPathSum(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        int[][] l = new int[x][y];

        l[0][0] = grid[0][0];
        for (int i = 1; i < x; i++)
            l[i][0] = l[i - 1][0] + grid[i][0];

        for (int i = 1; i < y; i++)
            l[0][i] = l[0][i - 1] + grid[0][i];

        for (int i = 1; i < x; i++)
            for (int j = 1; j < y; j++)
                l[i][j] = Math.min(l[i - 1][j], l[i][j - 1]) + grid[i][j];

        return l[x - 1][y - 1];
    }

}
