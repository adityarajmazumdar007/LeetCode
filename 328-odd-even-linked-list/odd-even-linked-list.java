class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode(-1);
        ListNode evenHead = new ListNode(-1);
        ListNode odd = oddHead;
        ListNode even = evenHead;
        int counter = 1;
        ListNode temp = head;
        while(temp != null) {
            if(counter % 2 == 1) {
                odd.next = temp;
                odd = odd.next;
            }
            else {
                even.next = temp;
                even = even.next;
            }
            temp = temp.next;
            counter++;
        }
        odd.next = evenHead.next;
        even.next = null;
        return oddHead.next;
    }
}