package com.liqudel.learndemo.sort;

public class HeapSort {

    int a[] = {42, 38, 45, 50, 47, 13, 27, 42};

    public void sort(int arr[]) {
        int n = arr.length;
        // 构建堆(重新排列数组)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // 提取一个个元素 （最大值）
        for (int i = n - 1; i >= 0; i--) {
            // 当前移动到末端
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    private void heapify(int arr[], int n, int i) {
        int largest = i;  // 最大值 （初始为根节点）
        int l = 2 * i + 1;  // 左节点
        int r = 2 * i + 2;  // 右节点
        // 如果左子节点大于根节点
        if (l < n && arr[l] > arr[largest])
            largest = l;
        // 如果右子节点大于最大节点（左子和根的）
        if (r < n && arr[r] > arr[largest])
            largest = r;
        // 如果根节点不是最大，则交换数值位置
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            // 递归调用
            heapify(arr, n, largest);
        }
    }
}
