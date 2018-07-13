package com.liqudel.learndemo.sort;

public class HeapSort implements Sort {

    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        // 构建堆(重新排列数组)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // 提取一个个元素 （最大值）
        for (int i = n - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    private void heapify(int arr[], int n, int i) {
        int largest = i;  // 最大值 （初始为根节点）
        int l = 2 * i + 1;  // 左节点
        int r = 2 * i + 2;  // 右节点
        if (l < n && arr[l] > arr[largest]) //比较左子节点和根节点
            largest = l;
        if (r < n && arr[r] > arr[largest]) //再与右子节点比较
            largest = r;
        if (largest != i) {  //如果根节点不是最大
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    private void swap(int arr[], int i, int largest) {
        int swap = arr[i];
        arr[i] = arr[largest];
        arr[largest] = swap;
    }

}
