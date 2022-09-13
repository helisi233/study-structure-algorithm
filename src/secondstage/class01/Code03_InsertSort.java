package secondstage.class01;

import firststage.utils.ArrayUtils;

// 插入排序
public class Code03_InsertSort {

    public static void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    public static void insertSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        // 从[1]开始 如果左边比它大交换
        // [1]~[n-1]
        for (int i = 1; i < arr.length; i++) {
//            for (int j = i; j > 0; j--) {
//                if(arr[j] < arr[j-1]) {
//                    swap(arr, j, j-1);
//                }
//            }
            for (int j = i-1; j >= 0 && arr[j] > arr[j+1]; j++) {
                swap(arr, j, j+1);
            }
        }
    }

    public static void main(String[] args) {
        int[] randomArray = ArrayUtils.generateRandomArray(20, 100);
        insertSort(randomArray);
        ArrayUtils.printlnArray(randomArray);
    }
}
