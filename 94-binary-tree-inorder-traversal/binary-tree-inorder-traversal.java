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
// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer>ans=new ArrayList<>();
//         if(root==null){
//             return ans;
//         }
//         ans.addAll(inorderTraversal(root.left));
//         ans.add(root.val);
//         ans.addAll(inorderTraversal(root.right));
//         return ans;
//     }
// }

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>ans=new ArrayList<>();
        helper(root,ans);
        return ans;
        
    }
    public static void helper(TreeNode root,List<Integer>ans){
        if(root==null){
            return;
        }
        helper(root.left,ans);
        ans.add(root.val);
        helper(root.right,ans);
        
    }
}