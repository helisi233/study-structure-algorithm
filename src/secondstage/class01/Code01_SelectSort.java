package secondstage.class01;

// 选择排序
public class Code01_SelectSort {

    public static void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    public static void selectSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        // 在0~N-1的位置上找到最小值 放到0位置上
        // 在1~N-1的位置上找到最小值 放到1位置上
        // 在2~N-1的位置上找到最小值 放到2位置上
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                minIndex = arr[minIndex] < arr[j] ? minIndex : j;
            }
            swap(arr, i, minIndex);
        }
    }

    public static void main(String[] args) {

    }
}
