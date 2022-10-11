package secondstage.class04;

import firststage.utils.ArrayUtils;

// 递归实现归并排序
public class Code01_MergeSort {
    public static void mergeSort(int[] arr) {
        process(arr, 0, arr.length-1);
    }

    public static void process(int[] arr, int l, int r) {
        if(l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        process(arr, l, mid);
        process(arr, mid+1, r);
        merge(arr, l, mid, r);
    }

    public static void merge(int[] arr, int l, int mid, int r) {
        int[] tmpArray = new int[r - l + 1];
        int index = 0;
        int p = l;
        int q = mid + 1;
        while(p <= mid && q <= r) {
            tmpArray[index++] = arr[p] > arr[q] ? arr[q++] : arr[p++];
        }
        while(p <= mid) {
            tmpArray[index++] = arr[p++];
        }
        while(q <= r) {
            tmpArray[index++] = arr[q++];
        }
        for (int i = 0; i < tmpArray.length; i++) {
            arr[i+l] = tmpArray[i];
        }
    }

    public static void main(String[] args) {
        int[] randomArray = ArrayUtils.generateRandomArray(20, 100);
        mergeSort(randomArray);
        ArrayUtils.printlnArray(randomArray);
    }
}
