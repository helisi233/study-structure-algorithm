package firststage.class08;

import firststage.utils.ArrayUtils;

public class Code03_QuickSort {

    public static void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int partition = -1;
        for (int index = start; index < end; index++) {
            if(array[index] <= pivot) {
                swap(array, index, ++partition);
            }
        }
        swap(array, ++partition, end);
        return partition;
    }

    public static int[] partition2(int[] array, int start, int end) {
        int index = 0;
        int less = -1;
        int more = end;

        while(index < more) {
            if(array[index] < array[end]) {
                swap(array, index++, ++less);
            }else if(array[index] > array[end]) {
                swap(array, index, --more);
            }else {
                index ++;
            }
        }
        swap(array, more, end);
        return new int[]{less, more};
    }

    public static void process(int[] array, int start, int end) {
        if(start >= end) {
            return;
        }
        int[] result = partition2(array, start, end);
        process(array, start, result[0]);
        process(array, result[1], end);
    }

    public static void quickSort(int[] array) {
        if(array == null || array.length < 2) {
            return;
        }
        process(array, 0, array.length-1);
    }

    public static void main(String[] args) {
        int[] randomArray = ArrayUtils.generateRandomArray(20, 100);
        quickSort(randomArray);
        ArrayUtils.printlnArray(randomArray);
    }
}
