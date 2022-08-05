package firststage.class01;

import firststage.utils.ArrayUtils;

public class Code03_BubbleSort {

    public static void bubbleSort(int[] array) {
        if(array == null || array.length < 2) {
            return;
        }
        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length-1; j++) {
                if(array[j] < array[j+1]) {
                    ArrayUtils.SwapElementArray(array, j, j+1);
                }
            }
        }
    }

    public static void bubbleSort2(int[] array) {
        if(array == null || array.length < 2) {
            return;
        }
        int length = array.length;
        for (int i = length-1; i >= 0; i--) {
            for (int j = 1; j < i; j++) {
                if(array[j-1] > array[j]) {
                    ArrayUtils.SwapElementArray(array, j, j-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] testArray = ArrayUtils.generateRandomArray(20, 100);
        bubbleSort2(testArray);
        ArrayUtils.printlnArray(testArray);
    }
}
