package com.liqudel.learndemo.sort;

import android.util.Log;

public class BinarySearch implements Sort {
    private static final String TAG = "BinarySearch";

    private int commonBinarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int middle = 0;            //定义middle

        //如果查找值不在数组区间，则无
        if (key < arr[low] || key > arr[high] || low > high) {
            return -1;
        }

        while (low <= high) {
            middle = (low + high) / 2;
            if (arr[middle] > key) {
                high = middle - 1;
            } else if (arr[middle] < key) {
                low = middle + 1;
            } else {
                return middle;
            }
        }
        return -1; //最后仍然没有找到，则返回-1
    }

    @Override
    public void sort(int[] a) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        int index = commonBinarySearch(arr, 9);
        Log.e(TAG, "index: " + index);
    }
}
