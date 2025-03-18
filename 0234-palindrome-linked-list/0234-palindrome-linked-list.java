class Solution {
    public ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseLinkedList(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
    public boolean isPalindrome(ListNode head) {
         if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = reverseLinkedList(slow.next);
        ListNode first = head;
        while (newHead != null) {
            if (first.val != newHead.val) {
                return false;
            }
            first = first.next;
            newHead = newHead.next;
        }
        return true; 
    }
}