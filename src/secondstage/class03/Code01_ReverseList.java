package secondstage.class03;

public class Code01_ReverseList {

    public static ListUtils.Node reverse(ListUtils.Node head) {
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

    public static void main(String[] args) {
        ListUtils.Node head = ListUtils.randomList(10, 100);
        ListUtils.printList(head);
        ListUtils.printList(reverse(head));
    }
}
