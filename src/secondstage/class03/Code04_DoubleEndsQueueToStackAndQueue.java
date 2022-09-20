package secondstage.class03;

public class Code04_DoubleEndsQueueToStackAndQueue {

    public static class DoubleNode {
        int value;
        DoubleNode last;
        DoubleNode next;
        public DoubleNode(int value) {
            this.value = value;
            this.last = null;
            this.next = null;
        }
    }

    public static class DoubleEndsQueue {
        public DoubleNode head;
        public DoubleNode tail;

        public void addFromHead(int value) {
            DoubleNode cur = new DoubleNode(value);
            if(head == null) {
                head = cur;
                tail = cur;
            }else {
                cur.next = head;
                head.last = cur;
                head = cur;
            }
        }

        public void addFromTail(int value) {
            DoubleNode cur = new DoubleNode(value);
            if(head == tail) {
                head = cur;
                tail = cur;
            }else {
                tail.next = cur;
                cur.last = tail;
                tail = cur;
            }
        }

        public Integer popFromHead() {
            if(head == null)
                return null;
            DoubleNode cur = head;
            if(head == tail) {
                head = null;
                tail = null;
            }else {
                head = head.next;
                cur.next = null;
                head.last = null;
            }
            return cur.value;
        }

        public Integer popFromTail() {
            if(tail == null)
                return null;
            DoubleNode cur = tail;
            if(tail == head) {
                tail = null;
                head = null;
            }else {
                tail = tail.last;
                tail.next = null;
                cur.last = null;
            }
            return cur.value;
        }

        public boolean isEmpty() {
            return head == tail;
        }
    }

    public static class MyStack {
        private DoubleEndsQueue queue;

        public MyStack() {
            queue = new DoubleEndsQueue();
        }

        public void push(int value) {
            queue.addFromHead(value);
        }

        public Integer pop() {
            return queue.popFromHead();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }

    public static class MyQueue {
        private DoubleEndsQueue queue;

        public MyQueue() {
            queue = new DoubleEndsQueue();
        }

        public void push(int value) {
            queue.addFromTail(value);
        }

        public Integer poll() {
            return queue.popFromHead();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }

    public static boolean isEqual(Integer o1, Integer o2) {
        if(o1 == null && o2 != null) {
            return false;
        }
        if(o1 != null && o2 == null) {
            return false;
        }
        if(o1 == null && o2 == null) {
            return true;
        }
        return o1.equals(o2);
    }
}
