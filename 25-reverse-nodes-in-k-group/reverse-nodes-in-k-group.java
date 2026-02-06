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
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr=head;
        ArrayList<Integer> list=new ArrayList<>();
        while(curr!=null){
            list.add(curr.val);
            curr=curr.next;
        }
        int n=list.size();
        for(int i=0;i<n;i+=k){
            if(i+k<=n){
                Collections.reverse(list.subList(i,i+k));
            }
        }
        curr=head;
        int indx=0;
        while(curr!=null){
            curr.val=list.get(indx++);
            curr=curr.next;
        }
        return head;
    }

}