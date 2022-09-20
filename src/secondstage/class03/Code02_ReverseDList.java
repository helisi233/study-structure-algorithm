package secondstage.class03;

public class Code02_ReverseDList {

    public static ListUtils.DNode reverse(ListUtils.DNode head) {
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
        ListUtils.DNode head = ListUtils.randomDList(10, 100);
        ListUtils.printDList(head);
        ListUtils.printDList(reverse(head));
    }
}
