package firststage.class01;

import firststage.utils.ArrayUtils;

public class Code04_InsertionSort {

    public static void insertSort(int[] array) {
        if(array == null || array.length < 2) {
            return;
        }
        int length = array.length;
        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0 && array[j] > array[j-1]; j--) {
                ArrayUtils.SwapElementArray(array, j, j-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] testArray = ArrayUtils.generateRandomArray(20, 100);
        insertSort(testArray);
        ArrayUtils.printlnArray(testArray);
    }
}
