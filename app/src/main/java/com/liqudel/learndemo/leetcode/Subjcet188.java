package com.liqudel.learndemo.leetcode;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 示例:
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class Subjcet188 implements Subjcet {
    private static final String TAG = "Subjcet628";

    @Override
    public void run() {
        List<List<Integer>> list = generate(5);
        Log.e(TAG, "run: " + list.toString());
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList();
        for (int i = 0; i < numRows; i++) {
            List mList = new ArrayList();
            for (int j = 0; j <= i; j++)
                mList.add(j == 0 || j == i ? 1 : list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
            list.add(mList);
        }
        return list;
    }


}
