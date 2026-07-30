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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        int sum=0;
        return pathSum(root,targetSum,sum);
    }
    boolean pathSum(TreeNode root,int targetSum,int sum){
        if(root==null){
            return false;
        }
        sum+=root.val;
        if(sum==targetSum && root.left==null && root.right==null){
            return true;
        }
        boolean left=pathSum(root.left,targetSum,sum);
        boolean right=pathSum(root.right,targetSum,sum);
        if(left||right){
            return true;
        }
        return false;
    }
}