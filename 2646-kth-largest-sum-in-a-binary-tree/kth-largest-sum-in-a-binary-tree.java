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
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> levelSum=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null){
            return -1;
        }
        q.add(root);
        long sum=0;
        while(!q.isEmpty()){
            
            int len=q.size();
            for(int i=0;i<len;i++){
                TreeNode curr=q.poll();
                // level.add(curr.val);
                sum+=curr.val;
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            levelSum.add(sum);
            sum=0;
        }
        if(levelSum.size()<k){
            return -1;
        }
        Collections.sort(levelSum);
        
        return levelSum.get(levelSum.size()-k);
    }
}