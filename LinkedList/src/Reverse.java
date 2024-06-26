public class Reverse {
    private ListNode head;
    private ListNode tail;
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return head;

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;

        while(curr != null){
            curr.next = prev;
            prev = curr;
            curr = next;

            if(next != null){
                next = next.next;
            }
        }
        head = prev;
        return head;
    }

    private void reverseRec(ListNode node){
        if(node == tail){
            head = tail;
            return;
        }

        reverseRec(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }
}
