package com.liqudel.learndemo.leetcode;

import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
 * 示例 1：
 * 输入： A = "ab", B = "ba"
 * 输出： true
 * 示例 2：
 * 输入： A = "ab", B = "ab"
 * 输出： false
 * 示例 3:
 * 输入： A = "aa", B = "aa"
 * 输出： true
 * 示例 4：
 * 输入： A = "aaaaaaabc", B = "aaaaaaacb"
 * 输出： true
 * 示例 5：
 * 输入： A = "", B = "aa"
 * 输出： false
 * 提示：
 * 0 <= A.length <= 20000
 * 0 <= B.length <= 20000
 * A 和 B 仅由小写字母构成。
 */
public class Subject859 implements Subjcet {
    private static final String TAG = "Subject860";

    @Override
    public void run() {
        boolean bool = buddyStrings("bbbb", "aaaa");
        Log.e(TAG, "run: " + bool);
    }


    private boolean buddyStrings(String A, String B) {
        if (A.length() != B.length())
            return false;
        HashSet hashSet = new HashSet();

        char[] achar = A.toCharArray();
        char[] bchar = B.toCharArray();

        char[] adiff = new char[2];
        char[] bdiff = new char[2];


        int d = 0;
        for (int i = 0; i < achar.length; i++) {
            hashSet.add(achar[i]);
            if (achar[i] != bchar[i]) {
                if (d == 2) {
                    return false;
                }
                adiff[d] = achar[i];
                bdiff[d] = bchar[i];
                d++;
            }
        }

        if (A.equals(B)) {
            return hashSet.size() != A.length();
        }

        return adiff[0] == bdiff[1] && adiff[1] == bdiff[0];
    }
}
