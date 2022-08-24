package firststage.class08;

import firststage.utils.ArrayUtils;

public class Code03_QuickSort {

    public static void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static int partition(int[] array, int l, int r) {
        int pivot = array[r];
        int partition = l-1;
        for (int i = l; i < r; i++) {
            if(array[i] < pivot) {
                swap(array, i, partition++);
            }
        }
        swap(array, r, partition);
        return partition;
    }

    public static void quickSort(int[] array, int l, int r) {
        if(array == null || array.length < 2) {
            return;
        }
        if(l > r) return;
        int partition = partition(array, l, r);
        quickSort(array, l, partition-1);
        quickSort(array, partition+1, r);
    }

    public static void main(String[] args) {
        int[] randomArray = ArrayUtils.generateRandomArray(20, 100);
        quickSort(randomArray, 0, randomArray.length-1);
        ArrayUtils.printlnArray(randomArray);
    }
}
