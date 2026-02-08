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

 //Top Down approach(0(n^2))
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        int lh=height(root.left);
        int rh=height(root.right);
        if(Math.abs(lh-rh)>1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(height(root.left),height(root.right))+1;
    }
}

//Bottom Up approach(O(n))
// class Solution {
//     public boolean isBalanced(TreeNode root) {
//         if(root==null){
//             return true;
//         }
//         return checkBalanceAndHeight(root) != -1;
//     }

//     // Returns height if balanced, -1 if unbalanced
//     private int checkBalanceAndHeight(TreeNode node) {
//         if (node == null) {
//             return 0; // Height of an empty tree is 0
//         }

//         int leftHeight = checkBalanceAndHeight(node.left);
//         if (leftHeight == -1) {
//             return -1; // Left subtree is unbalanced
//         }

//         int rightHeight = checkBalanceAndHeight(node.right);
//         if (rightHeight == -1) {
//             return -1; // Right subtree is unbalanced
//         }

//         if (Math.abs(leftHeight - rightHeight) > 1) {
//             return -1; // Current node is unbalanced
//         }

//         return 1 + Math.max(leftHeight, rightHeight); // Return height of current node
//     }
// }