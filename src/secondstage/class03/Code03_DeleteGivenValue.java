package secondstage.class03;

public class Code03_DeleteGivenValue {

    public static ListUtils.Node delete(ListUtils.Node head, int target) {
        while(head != null) {
            if(head.value != target) {
                break;
            }
            head = head.next;
        }
        ListUtils.Node prev = head;
        ListUtils.Node cur = head;
        while(cur != null) {
            if(cur.value == target) {
                prev.next = cur.next;
            }else {
                prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,3,2,4};
        ListUtils.Node head = new ListUtils.Node(2);
        ListUtils.Node cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListUtils.Node(arr[i]);
            cur = cur.next;
        }
        ListUtils.printList(delete(head, 2));
    }
}
