package firststage.class04;

public class Code02_LinkedListToQueueAndStack {

    public static class MyNode<V> {
        V element;
        MyNode next;
        public MyNode(V value) {
            this.element = value;
            this.next = null;
        }
    }

    public static class MyQueue<V> {
        MyNode head;
        MyNode tail;
        int size;

        public MyQueue() {
            head = null;
            tail = null;
            size = 0;
        }

        public int getSize() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void offer(V value) {
            MyNode cur = new MyNode(value);
            if(tail != null) {
                tail.next = cur;
                tail = cur;
            }else {
                head = tail = cur;
            }
            size ++;
        }

        public V poll() {
            V ans = null;
            if(head != null) {
                ans = (V)head.element;
                head = head.next;
                size--;
            }
            if(head == null) {
                tail = null;
            }
            return ans;
        }

        public V peek() {
            V ans = null;
            if(head != null) {
                ans = (V)head.element;
            }
            return ans;
        }
    }

    public static class MyStack<V> {
        MyNode head;
        MyNode tail;
        int size;

        public MyStack() {
            head = tail = null;
            size = 0;
        }

        public int getSize() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void push(V value) {
            MyNode cur = new MyNode(value);
            if(head == null) {
                head = tail = cur;
            }else {
                tail.next = cur;
                tail = cur;
            }
            size ++;
        }

        public V pop() {
            V ans = null;
            if(tail != null) {
                ans = (V)tail.element;
                size --;
            }else {
                head = tail = null;
            }
            return ans;
        }
    }
}
