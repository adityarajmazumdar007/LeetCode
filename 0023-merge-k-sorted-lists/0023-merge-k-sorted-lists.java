
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {   
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
       for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.offer(lists[i]);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while (!pq.isEmpty()) { //k*n +3*klogk
            ListNode least = pq.poll();
            temp.next = least;
            temp = temp.next;
            if (least.next != null) {
                pq.offer(least.next);
            }
        }
        return dummy.next;
    }
}