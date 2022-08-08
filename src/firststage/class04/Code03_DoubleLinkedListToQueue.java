package firststage.class04;

public class Code03_DoubleLinkedListToQueue<V> {

    public static class MyDNode<V> {
        V element;
        MyDNode next;
        MyDNode prev;
        public MyDNode(V value) {
            this.element = value;
            this.next = null;
            this.prev = null;
        }
    }

    private MyDNode head;
    private MyDNode tail;
    private int size;

    public Code03_DoubleLinkedListToQueue() {
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
        MyDNode cur = new MyDNode(value);
        if(tail != null) {
            tail.next = cur;
            cur.prev = tail;
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
            size --;
        }else {
            head = tail = null;
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
