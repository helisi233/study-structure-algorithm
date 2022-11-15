package secondstage.class05;

import firststage.utils.ArrayUtils;

import java.util.Random;

public class Code03_QuickSort {

    public static void main(String[] args) {
        int[] ints = ArrayUtils.generateRandomArray(20, 100);
        QuickSort(ints);
        ArrayUtils.printlnArray(ints);
    }

    public static void QuickSort(int[] array) {
        if(array == null || array.length < 2) {
            return;
        }
        process(array, 0, array.length-1);
    }

    public static void process(int[] array, int l, int r) {
        if(l >= r) {
            return;
        }
        // 使用随机数 优化
        swap(array, r, l + (int)(Math.random()*(r-l+1)));
        int[] boundary = partitions(array, l, r);
        process(array, l, boundary[0]-1);
        process(array, boundary[1]+1, r);
    }

    public static int[] partitions(int[] array, int l, int r) {
        int temp = array[r];
        int p = l - 1;
        int q = r;
        int index = l;
        while(index < q) {
            if(array[index] == temp) {
                index ++;
            }else if(array[index] > temp) {
                swap(array, index, --q);
            }else {
                swap(array, index++, ++p);
            }
        }
        swap(array, q, r);
        return new int[]{p+1, q};
    }

    public static void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
