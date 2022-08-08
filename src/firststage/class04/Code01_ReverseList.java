package firststage.class04;

import firststage.utils.ListUtils;

public class Code01_ReverseList {

    public static ListUtils.Node reverseList(ListUtils.Node head) {
        if(head == null) {
            return null;
        }
        ListUtils.Node prev = null;
        ListUtils.Node next = head;
        ListUtils.Node cur = head;
        while(cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static ListUtils.DNode reverseDList(ListUtils.DNode head) {
        if(head == null) {
            return null;
        }
        ListUtils.DNode prev = null;
        ListUtils.DNode next = head;
        ListUtils.DNode cur = head;
        while(cur != null) {
            next = cur.next;
            cur.next = prev;
            cur.prev = next;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void main(String[] args) {
//        ListUtils.Node head = ListUtils.generateRandomList(100, 10);
//        System.out.println(ListUtils.printList(head));
//        ListUtils.Node newHead = reverseList(head);
//        System.out.println(ListUtils.printList(newHead));

        ListUtils.DNode head = ListUtils.generateRandomDList(100, 10);
        System.out.println(ListUtils.printAscDList(head));
        ListUtils.DNode newHead = reverseDList(head);
        System.out.println(ListUtils.printAscDList(newHead));
        System.out.println(ListUtils.printDescDList(newHead));
    }
}
