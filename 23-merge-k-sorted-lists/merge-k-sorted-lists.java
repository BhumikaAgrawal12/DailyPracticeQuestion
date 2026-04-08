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
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> arr=new ArrayList<>();
        int n=lists.length;
        for(int i=0;i<n;i++){
            ListNode temp=lists[i];
            while(temp!=null){
                arr.add(temp.val);
                temp=temp.next;
            }
        }
        if(arr.size() == 0) return null;
        Collections.sort(arr);
        ListNode head=convert(arr);
        return head;
    }
    public ListNode convert(List<Integer> arr){
        ListNode head=new ListNode(arr.get(0));
        ListNode curr=head;
        for(int i=1;i<arr.size();i++){
            curr.next=new ListNode(arr.get(i));
            curr=curr.next;
        }
        return head;
    }
}