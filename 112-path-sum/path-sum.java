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
        return check(root,sum,targetSum);
    }
    public boolean check(TreeNode root,int sum,int target){
        if(root==null){
            return false;
        }
        sum+=root.val;
        if(sum==target && root.left==null && root.right==null){
            return true;
        }
        boolean left=check(root.left,sum,target);
        boolean right=check(root.right,sum,target);
        if(left || right){
            return true;
        }
        return false;
    }
}