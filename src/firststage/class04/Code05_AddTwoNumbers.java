package firststage.class04;

import firststage.utils.ListUtils;

public class Code05_AddTwoNumbers {

    public static ListUtils.Node addTwoNumbers(ListUtils.Node head1, ListUtils.Node head2) {
        int length1 = ListUtils.lengthList(head1);
        int length2 = ListUtils.lengthList(head2);
        ListUtils.Node l = length1 >= length2 ? head1 : head2;
        ListUtils.Node s = l == head1 ? head2 : head1;
        ListUtils.Node curL = l;
        ListUtils.Node curS = s;
        ListUtils.Node last = curL;
        int carry = 0;
        int curNum = 0;
        while(curS != null) {
            curNum = curS.element + curL.element + carry;
            curL.element = curNum % 10;
            carry = curNum / 10;
            last = curL;
            curL = curL.next;
            curS = curS.next;
        }
        while(curL != null) {
            curNum = curL.element + carry;
            curL.element = curNum % 10;
            carry = curNum / 10;
            last = curL;
            curL = curL.next;
        }
        if(carry != 0) {
            last.next = new ListUtils.Node(1);
        }
        return l;
    }

    public static void main(String[] args) {
        ListUtils.Node head1 = ListUtils.generateRandomList(10, 4);
        System.out.println(ListUtils.printList(head1));
        ListUtils.Node head2 = ListUtils.generateRandomList(10, 4);
        System.out.println(ListUtils.printList(head2));
        ListUtils.Node newhead = addTwoNumbers(head1, head2);
        System.out.println(ListUtils.printList(newhead));
    }
}
