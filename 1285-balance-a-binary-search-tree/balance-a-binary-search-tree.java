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
    ArrayList<TreeNode> arr = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
       inOrder(root);
       return buildTree(0,arr.size()-1);

    }
    public  void inOrder(TreeNode root)
    {
        if(root==null)
        return;

        inOrder(root.left);
        arr.add(root);
        inOrder(root.right);
    }
    public  TreeNode buildTree(int start,int end)
    {
        if(start > end)return null;
        int mid=start + (end - start) / 2;
        TreeNode root=arr.get(mid);

        root.left=buildTree(start,mid-1);
        root.right=buildTree(mid+1,end);

        return root;
    }
}