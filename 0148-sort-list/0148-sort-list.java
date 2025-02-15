
class Solution {
    public ListNode findMid(ListNode head){
        ListNode slow=head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode mergeLists(ListNode list1, ListNode list2){
        if(list1==null && list2 ==null)return list1;
        ListNode dummy= new ListNode(-1);
        ListNode temp = dummy;
        while(list1 !=null && list2 !=null){
            if(list2.val >= list1.val){
                temp.next=list1;
                list1=list1.next;
                temp=temp.next;
            }
            else{
                temp.next=list2;
                list2=list2.next;
                temp=temp.next;
            }
        }
        while(list1!=null){
            temp.next=list1;;
            list1=list1.next;
            temp=temp.next;
        }
        while(list2 !=null){
            temp.next=list2;
                list2=list2.next;
                temp=temp.next;
        }
        
   return dummy.next; 
    }
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)return head;
        ListNode temp=head;
        ListNode mid= findMid(temp);
        ListNode left=head;
        ListNode right= mid.next;
        mid.next=null;
        left=sortList(left);
        right=sortList(right);
        return mergeLists(left,right);
        
    }
}