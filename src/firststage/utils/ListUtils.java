package firststage.utils;

public class ListUtils {

    public static class Node {
        public int element;
        public Node next;
        public Node(int element) {
            this.element = element;
            this.next = null;
        }
    }

    public static class DNode {
        int element;
        public DNode prev;
        public DNode next;
        public DNode(int element) {
            this.element = element;
            this.prev = null;
            this.next = null;
        }
    }

    public static DNode generateRandomDList(int maxValue, int length) {
        DNode head = new DNode((int)(Math.random() * maxValue));
        DNode cur = head;
        for (int i = 1; i < length; i++) {
            DNode newNode = new DNode((int)(Math.random() * maxValue));
            cur.next = newNode;
            newNode.prev = cur;
            cur = cur.next;
        }
        return head;
    }

    public static String printAscDList(DNode head) {
        if(head == null) {
            return null;
        }
        StringBuilder res = new StringBuilder();
        DNode cur = head;
        while(cur != null) {
            res.append(cur.element + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }

    public static String printDescDList(DNode head) {
        if(head == null) {
            return null;
        }
        StringBuilder res = new StringBuilder();
        DNode cur = head;
        while(cur.next != null) {
            cur = cur.next;
        }
        while(cur != null) {
            res.append(cur.element + "->");
            cur = cur.prev;
        }
        res.append("NULL");
        return res.toString();
    }

    public static Node generateRandomList(int maxValue, int length) {
        Node head = new Node((int)(Math.random() * maxValue));
        Node cur = head;
        for (int i = 1; i < length; i++) {
            cur.next = new Node((int)(Math.random() * maxValue));
            cur = cur.next;
        }
        return head;
    }

    public static String printList(Node head) {
        if(head == null) {
            return null;
        }
        Node cur = head;
        StringBuilder res = new StringBuilder();
        while(cur != null) {
            res.append(cur.element + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }

    public static int lengthList(Node head) {
        Node cur = head;
        int length = 0;
        while(cur != null) {
            length ++;
            cur = cur.next;
        }
        return length;
    }

}
