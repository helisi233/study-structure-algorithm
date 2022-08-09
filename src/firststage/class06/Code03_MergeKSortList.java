package firststage.class06;

import firststage.utils.ListUtils;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code03_MergeKSortList {

    public static class NodeComparator implements Comparator<ListUtils.Node> {
        @Override
        public int compare(ListUtils.Node o1, ListUtils.Node o2) {
            return o1.element - o2.element;
        }
    }

    public static ListUtils.Node mergeKSortList(ListUtils.Node[] nodes) {
        if(nodes == null) {
            return null;
        }
        PriorityQueue<ListUtils.Node> heap = new PriorityQueue<>(new NodeComparator());
        for (int i = 0; i < nodes.length; i++) {
            if(nodes[i] != null) {
                heap.add(nodes[i]);
            }
        }
        if(heap.isEmpty()) {
            return null;
        }
        ListUtils.Node newhead = heap.poll();
        ListUtils.Node prev = newhead;
        if(prev.next != null) {
            heap.add(prev.next);
        }
        while(!heap.isEmpty()) {
            ListUtils.Node cur = heap.poll();
            prev.next = cur;
            prev = cur;
            if(cur.next != null) {
                heap.add(cur.next);
            }
        }
        return newhead;
    }

    public static void main(String[] args) {
        ListUtils.Node head1 = new ListUtils.Node(1);
        head1.next = new ListUtils.Node(2);
        head1.next.next = new ListUtils.Node(6);
        head1.next.next.next = new ListUtils.Node(7);

        ListUtils.Node head2 = new ListUtils.Node(2);
        head2.next = new ListUtils.Node(4);
        head2.next.next = new ListUtils.Node(4);
        head2.next.next.next = new ListUtils.Node(5);

        ListUtils.Node head3 = new ListUtils.Node(3);
        head3.next = new ListUtils.Node(7);
        head3.next.next = new ListUtils.Node(7);
        head3.next.next.next = new ListUtils.Node(9);

        ListUtils.Node[] nodes = {head1, head2, head3};
        ListUtils.Node head = mergeKSortList(nodes);
        System.out.println(ListUtils.printList(head));
    }
}
