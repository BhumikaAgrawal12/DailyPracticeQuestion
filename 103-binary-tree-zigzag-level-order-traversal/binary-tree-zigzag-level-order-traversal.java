/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         List<List<Integer>> ans=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null){
            return ans;
        }
        q.add(root);
        int indx=-1;
        while(!q.isEmpty()){
            ArrayList<Integer> level=new ArrayList<>();
            int len=q.size();
            indx++;
            for(int i=0;i<len;i++){
                TreeNode curr=q.poll();
                level.add(curr.val);
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            if(indx%2==0){
                ans.add(level);
            }
            else{
                Collections.reverse(level);
                ans.add(level);
            }
        }
        return ans;
    }
}