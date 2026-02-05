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
    public int[] nextLargerNodes(ListNode head) {
        ListNode prev=head;
        ListNode curr=head.next;
        int cnt=1;
        while(curr!=null){
            ListNode nxt=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nxt;
            cnt++;
        }
        head.next=null;
        head=prev;
        // System.out.println(head.val);
        // System.out.println(head.next.val);
        
        // while(head!=null){
        //     System.out.println(head.val);
        //     head = head.next ;
        // }
        ArrayDeque<Integer> st=new ArrayDeque<>();
        int[] ans=new int[cnt];
        cnt=cnt-1;


        while(head!=null){
            while(!st.isEmpty() && st.peek()<=head.val){
                st.pop();
            }
            if(st.isEmpty()){
                ans[cnt--]=0;
            }
            else{
                ans[cnt--]=st.peek();
            }
            st.push(head.val);
            head=head.next;
        }
        return ans;
    }
}