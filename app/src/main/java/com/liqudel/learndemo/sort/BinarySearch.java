package com.liqudel.learndemo.sort;

import android.util.Log;

public class BinarySearch implements Search {
    private static final String TAG = "二分查找";


    private static BinarySearch binarySearch;

    private BinarySearch() {
    }

    public static void doSearch(int[] numArr) {
        if (binarySearch == null) {
            binarySearch = new BinarySearch();
        }

        int searchValue = createSearchValue(numArr);
        binarySearch.search(numArr, searchValue);
    }

    private int commonBinarySearch(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        int middle;

        //如果查找值不在数组区间，则无
        if (value < arr[low] || value > arr[high] || low > high) {
            return -1;
        }

        while (low <= high) {
            middle = (low + high) / 2;
            if (arr[middle] > value) {
                high = middle - 1;
            } else if (arr[middle] < value) {
                low = middle + 1;
            } else {
                return middle;
            }
        }
        return -1; //最后仍然没有找到，则返回-1
    }

    @Override
    public void search(int[] arr, int value) {
        int index = commonBinarySearch(arr, value);
        Log.e(TAG, "查找结果：" + " value: " + value + "  index: " + index);
    }

    private static int createSearchValue(int[] numArr) {
        return Math.random() > 0.7f ? (int) (Math.random() * 100) : numArr[(int) (Math.random() * numArr.length)];
    }

}
