/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

 //brute force
// class Solution {
//     public ListNode mergeKLists(ListNode[] lists) {
//         List<Integer> arr=new ArrayList<>();
//         int n=lists.length;
//         for(int i=0;i<n;i++){
//             ListNode temp=lists[i];
//             while(temp!=null){
//                 arr.add(temp.val);
//                 temp=temp.next;
//             }
//         }
//         if(arr.size() == 0) return null;
//         Collections.sort(arr);
//         ListNode head=convert(arr);
//         return head;
//     }
//     public ListNode convert(List<Integer> arr){
//         ListNode head=new ListNode(arr.get(0));
//         ListNode curr=head;
//         for(int i=1;i<arr.size();i++){
//             curr.next=new ListNode(arr.get(i));
//             curr=curr.next;
//         }
//         return head;
//     }
// }

//approach->Merge 2sorted lists
// class Solution {
//     public ListNode mergeKLists(ListNode[] lists) {
//         if(lists==null || lists.length==0){
//             return null;
//         }
//         ListNode head=lists[0];
//         for(int i=1;i<lists.length;i++){
//             head=merge(head,lists[i]);
//         }
//         return head;
//     }
//     public ListNode merge (ListNode one,ListNode two){
//         ListNode dummy=new ListNode(-1);
//         ListNode tail=dummy;
//         ListNode curr1=one;
//         ListNode curr2=two;
//         while(curr1!=null && curr2!=null){
//             if(curr1.val<curr2.val){
//                 tail.next=curr1;
//                 curr1=curr1.next;
//             }
//             else{
//                 tail.next=curr2;
//                 curr2=curr2.next;
//             }
//             tail=tail.next;
//         }
//         if(curr1!=null){
//             tail.next=curr1;
//             curr1=curr1.next;
//         }
//         if(curr2!=null){
//             tail.next=curr2;
//             curr2=curr2.next;
//         }
//         return dummy.next;
//     }
// }

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);

        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;

        for(int i=0;i<lists.length;i++){
             if(lists[i] != null){
                pq.add(lists[i]);
            }
        }
        while(!pq.isEmpty()){
            ListNode curr=pq.poll();
            temp.next=curr;
            if(curr.next != null){
                pq.add(curr.next);
            }
            temp=temp.next;
        }
        return dummy.next;
    }
}