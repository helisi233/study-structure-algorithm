package secondstage.class01;

import firststage.utils.ArrayUtils;

// 冒泡排序
public class Code02_BubbleSort {

    public static void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    public static void bubbleSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        // 第一次循环
        // [0]与[1]比较 大的往后排
        // [1]与[2]比较 大的往后排
        // ......
        // [n-2]与[n-1]比较 大的往后排 ==> [n-1]位置就是数组最大值
        // 第二次循环
        // [0]~[n-2] 重复上次操作
        for (int i = arr.length-1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if(arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] randomArray = ArrayUtils.generateRandomArray(20, 100);
        bubbleSort(randomArray);
        ArrayUtils.printlnArray(randomArray);
    }
}
