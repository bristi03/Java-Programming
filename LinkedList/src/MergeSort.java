public class MergeSort {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next ==null)
            return head;

        ListNode mid = middleNode(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left, right);
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyhead = new ListNode();
        ListNode ans = dummyhead;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                ans.next = list1; //assigning list1 node to ans-> next
                list1= list1.next;
            }
            else{
                ans.next = list2;
                list2= list2.next;
            }
            ans = ans.next; //moving ans to point to the new assigned node
        }
        ans.next = (list1 != null)? list1 : list2;
        return dummyhead.next;
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = head;

        while(fast != null && fast.next != null){
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        temp.next = null; //breaking the list into halves
        return slow; //when fast reaches null, slow wouldve covered half the path
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
