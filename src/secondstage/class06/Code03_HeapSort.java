package secondstage.class06;

import static secondstage.class06.Code02_Heap.*;

public class Code03_HeapSort {

    /*
    *   对数组里每一个数字都做一次heapinsert 形成一个大根堆/小根堆
    *   堆最上面的元素就是最大值 heapsize--
    * */
    public static void heapSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            heapInsert(array, i);
        }
//        for (int i = array.length-1; i >= 0; i--) {
//            heapify(array, i, array.length);
//        }
        int heapSize = array.length;
        swap(array, 0, --heapSize);
        while(heapSize > 0) {
            heapify(array, 0, heapSize);
            swap(array, 0, --heapSize);
        }
    }

    public static void main(String[] args) {

    }
}
