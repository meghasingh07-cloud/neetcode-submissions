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
    private int count=0;
    private int result=0;
    public int kthSmallest(TreeNode root, int k) {
       count=0;
       inorder(root,k);
       return result;
    }
    private void inorder(TreeNode root, int k) {
        if(root==null) return;
        inorder(root.left,k);
        count++;
        if(k==count){
            result=root.val;
            return;
        }
        if (count < k) {
            inorder(root.right, k);

    }
}
}
