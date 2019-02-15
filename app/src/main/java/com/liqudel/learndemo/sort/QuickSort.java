package com.liqudel.learndemo.sort;

import android.util.Log;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort implements Sort {
    private static final String TAG = "快速排序";

    private static QuickSort quickSort;

    private QuickSort() {
    }

    public static void doSort(int[] arr) {
        if (quickSort == null) {
            quickSort = new QuickSort();
        }
        quickSort.sort(arr);

        Log.e(TAG, "排序结果" + Arrays.toString(arr));
    }

    @Override
    public void sort(int[] a) {
        qsort(a, 0, a.length - 1);
    }

    private void qsort(int a[], int i, int j) {
        int pivot;
        if (i < j) {
            pivot = partition(a, i, j);  //  将a[] 一分为二，算出枢轴值pivot

            qsort(a, i, pivot - 1);   //  对低子表递归排序
            qsort(a, pivot + 1, j);   //  对高子表递归排序
        }
    }

    private int partition(int a[], int i, int j) {
        int pivotkey = a[i];   /* 用子表的第一个记录作枢轴记录 */
        while (i < j) {
            while (i < j && a[j] >= pivotkey) //从右往左，找比枢轴小的值
                j--;
            swap(a, i, j);
            while (i < j && a[i] <= pivotkey)//从左往右，找比枢轴大的值
                i++;
            swap(a, i, j);
        }
        return i;
    }

    //交换位置
    private void swap(int[] a, int low, int high) {
        int k = a[low];
        a[low] = a[high];
        a[high] = k;
    }
}
