package com.liqudel.learndemo.leetcode;


import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 例如，给定三角形：
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 说明：
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 */
public class Subject120 implements Subjcet {
    private static final String TAG = "Subject120";

    int[] inits = new int[]{2, 3, 4, 6, 5, 7, 4, 1, 8, 3};


    @Override
    public void run() {
        int k = 0;
        List list = new ArrayList();
        for (int i = 0; i < 4; i++) {
            List mlist = new ArrayList();
            for (int j = 0; j < i + 1; j++) {
                mlist.add(inits[k]);
                k++;
            }
            list.add(mlist);

        }


        int n = minimumTotal(list);
        Log.e(TAG, "run: " + n);

    }

    public int minimumTotal(List<List<Integer>> triangle) {
/*
        triangle.get(1).set(0, triangle.get(0).get(0));
        triangle.get(1).set(1, triangle.get(0).get(0));


        triangle.get(2).set(0, triangle.get(1).get(0));
        triangle.get(2).set(1, Math.min(triangle.get(1).get(0), triangle.get(0).get(1)));
        triangle.get(2).set(2, triangle.get(1).get(1));


        triangle.get(3).set(0, triangle.get(2).get(0));
        triangle.get(3).set(1, Math.min(triangle.get(2).get(0), triangle.get(0).get(1)));
        triangle.get(3).set(2, Math.min(triangle.get(2).get(1), triangle.get(0).get(2)));
        triangle.get(3).set(3, triangle.get(2).get(2));*/

/*
        triangle.get(4).set(0, triangle.get(0).get(0));
        triangle.get(4).set(1, Math.min(triangle.get(0).get(0), triangle.get(0).get(1)));
        triangle.get(4).set(2, Math.min(triangle.get(0).get(1), triangle.get(0).get(2)));
        triangle.get(4).set(3, Math.min(triangle.get(0).get(2), triangle.get(0).get(3)));
        triangle.get(4).set(4, triangle.get(0).get(2));
*/

        for (int i = 1; i < triangle.size(); i++) {

            for (int j = 0; j <= i; j++) {
                Log.e(TAG, "i:   " + i + "   j :" + j);
                int value;
                if (j == 0 || j == i ) {
                    value = triangle.get(i - 1).get(j);
                } else {
                    value = Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j));
                }


                triangle.get(i).set(j, value);

            }

        }

        int m = 999;
        for (int i : triangle.get(triangle.size() - 1)) {
            if (i < m) m = i;
        }

        return m;
    }
}
