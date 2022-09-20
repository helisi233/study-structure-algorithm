package secondstage.class03;

public class ListUtils {

    public static class Node {
        int value;
        Node next;
        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static Node randomList(int maxLength, int maxValue) {
        Node head = new Node((int)(Math.random() * maxValue));
        Node cur = head;
        for (int i = 1; i < maxLength; i++) {
            cur.next = new Node((int)(Math.random() * maxValue));
            cur = cur.next;
        }
        return head;
    }

    public static void printList(Node head) {
        if(head == null) {
            throw new IllegalArgumentException("invalid head");
        }
        Node cur = head;
        while(cur.next != null) {
            System.out.print(cur.value + "->");
            cur = cur.next;
        }
        System.out.println(cur.value);
    }

    public static class DNode {
        int value;
        DNode next;
        DNode prev;
        public DNode(int value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    public static DNode randomDList(int maxLength, int maxValue) {
        DNode head = new DNode((int)(Math.random() * maxValue));
        DNode cur = head;
        for (int i = 1; i < maxLength; i++) {
            cur.next = new DNode((int)(Math.random() * maxValue));
            cur = cur.next;
        }
        return head;
    }

    public static void printDList(DNode head) {
        DNode cur = head;
        while(cur.next != null) {
            System.out.print(cur.value + "->");
            cur = cur.next;
        }
        System.out.println(cur.value);
    }

}
