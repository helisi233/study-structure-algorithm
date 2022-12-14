package firststage.class04;

import firststage.utils.ListUtils;

public class Code04_ReverseNodesInKGroup {

    public static ListUtils.Node getKgroupNode(ListUtils.Node start, int k) {
        while(--k != 0 && start != null) {
            start = start.next;
        }
        return start;
    }

    public static void reverse(ListUtils.Node start, ListUtils.Node end) {
        end = end.next;
        ListUtils.Node prev = null;
        ListUtils.Node next = null;
        ListUtils.Node cur = start;
        while(cur != end) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        start.next = end;
    }

    public static ListUtils.Node reverseKGroup(ListUtils.Node head, int k) {
        ListUtils.Node start = head;
        ListUtils.Node end = getKgroupNode(start, k);
        if(end == null) {
            return start;
        }
        ListUtils.Node newHead = end;
        reverse(start, end);
        ListUtils.Node lastEnd = start;
        while(lastEnd.next != null) {
            start = lastEnd.next;
            end = getKgroupNode(start, k);
            if(end == null) {
                return newHead;
            }
            reverse(start, end);
            lastEnd.next = end;
            lastEnd = start;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListUtils.Node head = ListUtils.generateRandomList(100, 20);
        System.out.println(ListUtils.printList(head));
        ListUtils.Node newhead = reverseKGroup(head, 3);
        System.out.println(ListUtils.printList(newhead));
    }
}
