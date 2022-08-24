package firststage.class08;

import firststage.utils.ArrayUtils;

public class Code01_MergeSort {

    public static void mergeSort(int[] array) {
        if(array == null || array.length < 2) {
            return;
        }
        process(array, 0, array.length-1);
    }

    public static void process(int[] array, int start, int end) {
        if(start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        process(array, start, mid);
        process(array, mid+1, end);
        merge(array, start, mid, end);
    }

    public static void merge(int[] array, int start, int mid, int end) {
        int[] aux = new int[end - start + 1];
        int p = start;
        int q = mid+1;
        int index = 0;

        while(p <= mid && q <= end) {
            aux[index++] = array[p] > array[q] ? array[q++] : array[p++];
        }
        while(p <= mid) {
            aux[index++] = array[p++];
        }
        while(q <= end) {
            aux[index++] = array[q++];
        }

        for (int i = 0; i < aux.length; i++) {
            array[start+i] = aux[i];
        }
    }

    public static void main(String[] args) {
        int[] randomArray = ArrayUtils.generateRandomArray(10, 100);
        mergeSort(randomArray);
        ArrayUtils.printlnArray(randomArray);
    }
}
