package secondstage.class06;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code02_Heap {
    // 初始状态10个元素的数组
    private static int[] heap = new int[10];
    private static int heapSize;   // 当前要插入数据的位置

    public static void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public static void heapInsert(int[] heap, int index) {
        while(heap[index] > heap[(index-1)/2]) {
            swap(heap, index, (index-1)/2);
            index = (index-1)/2;
        }
    }

    public static void heapify(int[] heap, int index, int heapSize) {
        int left = index * 2 + 1;
        while(left < heapSize) {
            int largest = left+1 < heapSize &&
                    heap[left+1] > heap[left] ? left+1 : left;
            largest = heap[largest] > heap[index] ? largest : index;
            if(largest == index) {
                break;
            }
            swap(heap, largest, index);
            index = largest;
            left = largest * 2 + 1;
        }
    }

    // 小根堆与大根堆的转换 只需要自定义排序器
    public static class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;     // 大根堆的定义方式
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(new MyComparator());
        heap.add(5);
        heap.add(3);
        heap.add(7);
        heap.add(0);
        while(!heap.isEmpty()) {
            System.out.print(heap.poll() + " ");
        }
    }
}
