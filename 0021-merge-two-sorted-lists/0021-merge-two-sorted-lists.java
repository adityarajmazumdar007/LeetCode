class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
        
   return dummy.next; }
}