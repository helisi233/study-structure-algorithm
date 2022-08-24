package firststage.class08;

import firststage.utils.ArrayUtils;

public class Code02_MergeSortIteration {

    public static void mergeSortIteration(int[] array) {
         if(array == null || array.length < 2) {
             return;
         }
         int step = 1;
         int len = array.length;
         while(step < len) {

             int l = 0;
             while(l < len) {
                 int mid = 0;
                 if(len-l >= step) {
                     mid = l+step-1;
                 }else {
                     mid = len-1;
                 }

                 if(mid == len-1) {
                     break;
                 }

                 int r = 0;
                 if(len-1-mid >= step) {
                     r = mid+step;
                 }else {
                     r = len-1;
                 }

                 merge(array, l, mid, r);

                 if(r == len-1) {
                     break;
                 }else {
                     l = r+1;
                 }
             }

             if(step > (len/2)) {
                 break;
             }else {
                 step *= 2;
             }
         }
    }

    public static void merge(int[] array, int l, int mid, int r) {
        int[] test = new int[r-l+1];
        int p = l;
        int q = mid+1;
        int index = 0;

        while(p <= mid && q <= r) {
            test[index++] = array[p] > array[q] ? array[q++] : array[p++];
        }

        while(p <= mid) {
            test[index++] = array[p++];
        }

        while(q <= r) {
            test[index++] = array[q++];
        }

        for (int i = 0; i < test.length; i++) {
            array[l+i] = test[i];
        }
    }

    public static void main(String[] args) {
        int[] randomArray = ArrayUtils.generateRandomArray(20, 100);
        mergeSortIteration(randomArray);
        ArrayUtils.printlnArray(randomArray);
    }
}
