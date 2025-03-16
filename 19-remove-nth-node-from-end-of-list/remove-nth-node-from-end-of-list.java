class Solution {
   private static int length(ListNode head){
       int count =0;
       while(head!=null){
           count++;
           head=head.next;
       }
       return count;
   }
   
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int len= length(temp);
        temp=head;
        if(n==len)return head.next;
        int res= len-n;
        int count=0;
        while(temp!=null){
            if(count == res-1)break;
            count++;
            temp=temp.next;
        }
        temp.next=temp.next.next;
        return head;
        
    }
}