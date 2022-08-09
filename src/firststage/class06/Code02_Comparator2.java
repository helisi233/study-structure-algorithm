package firststage.class06;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code02_Comparator2 {

    public static class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            if(o1 > o2) {
                return -1;
            }else if(o1 < o2) {
                return 1;
            }else {
                return 0;
            }
        }
    }

    /**
     *  优先级队列
     *  add(element) 添加
     *  peek() 获取队列第一个元素
     *  poll() 弹出第一个元素
     * */
    public static void main(String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(new MyComparator());
        heap.add(6);
        heap.add(2);
        heap.add(3);
        heap.add(1);
        heap.add(7);
        System.out.println(heap.peek());
        heap.add(0);
        System.out.println(heap.peek());
        System.out.println("========");
        while(!heap.isEmpty()) {
            System.out.println(heap.poll());
        }

        /**
         *  针对字符串按照字典序排序
         *  长度相同挨个比较
         *  长度不同 短的补齐等长 使用最小的asc码补齐
         * */
        String str1 = "abc";
        String str2 = "b";
        System.out.println(str1.compareTo(str2));
    }
}
