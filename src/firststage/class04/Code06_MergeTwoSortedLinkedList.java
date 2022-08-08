package firststage.class04;

import firststage.utils.ListUtils;

public class Code06_MergeTwoSortedLinkedList {

    public static ListUtils.Node mergeTwoLists(ListUtils.Node head1, ListUtils.Node head2) {
        if(head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        ListUtils.Node head = head1.element < head2.element ? head1 : head2;
        ListUtils.Node cur1 = head.next;
        ListUtils.Node cur2 = head == head1 ? head2 : head1;
        ListUtils.Node pre = head;
        while(cur1 != null && cur2 != null) {
            if(cur1.element <= cur2.element) {
                pre.next = cur1;
                cur1 = cur1.next;
            }else {
                pre.next = cur2;
                cur2 = cur2.next;
            }
            pre = pre.next;
        }
        pre.next = cur1 != null ? cur1 : cur2;
        return head;
    }

    public static void main(String[] args) {
//        1->3->3->5->7    2->2->3->3->7
        ListUtils.Node head1 = new ListUtils.Node(1);
        head1.next = new ListUtils.Node(3);
        head1.next.next = new ListUtils.Node(3);
        head1.next.next.next = new ListUtils.Node(5);
        head1.next.next.next.next = new ListUtils.Node(7);

        ListUtils.Node head2 = new ListUtils.Node(2);
        head2.next = new ListUtils.Node(2);
        head2.next.next = new ListUtils.Node(3);
        head2.next.next.next = new ListUtils.Node(3);
        head2.next.next.next.next = new ListUtils.Node(7);

        ListUtils.Node head = mergeTwoLists(head1, head2);
        System.out.println(ListUtils.printList(head));
    }
}
