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
    int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum=Integer.MIN_VALUE;
        calcGain(root);
        return maxSum;

    }
    public int calcGain(TreeNode root){
        if(root==null) return 0;
        int leftGain=Math.max(0,calcGain(root.left));
        int rightGain=Math.max(0,calcGain(root.right));
        int currSum= root.val+leftGain+rightGain;
        maxSum=Math.max(currSum,maxSum);
        return root.val+Math.max(leftGain,rightGain);
    }
    
}
