package firststage.class01;

import firststage.utils.ArrayUtils;

public class Code02_SelectionSort {

    public static void selectSort(int[] array) {
        if(array == null || array.length < 2) {
            return;
        }
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int maxIndex = i;
            for (int j = i+1; j < length; j++) {
                maxIndex = array[maxIndex] < array[j] ? j : maxIndex;
            }
            ArrayUtils.SwapElementArray(array, maxIndex, i);
        }
    }

    public static void main(String[] args) {
        int[] testArray = ArrayUtils.generateRandomArray(20, 100);
        selectSort(testArray);
        ArrayUtils.printlnArray(testArray);
    }
}
