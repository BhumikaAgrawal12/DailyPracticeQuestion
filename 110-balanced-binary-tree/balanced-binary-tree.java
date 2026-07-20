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
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        // int left=height(root.left);
        // int right=height(root.right);
        // if(Math.abs(left-right)>1){
        //     return false;
        // }
        // return isBalanced(root.left) && isBalanced(root.right);
        return height(root)!=-1;
    }
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int lh=height(root.left);
        if(lh==-1){
            return -1;
        }
        int rh=height(root.right);
        if(rh==-1){
            return -1;
        }

        if(Math.abs(lh-rh)>1){
            return -1;
        }
        return 1+Math.max(lh,rh);
    }
}