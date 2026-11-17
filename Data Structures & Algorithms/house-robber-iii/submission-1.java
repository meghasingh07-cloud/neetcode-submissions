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
    private Map<TreeNode, Integer> memo = new HashMap<>();
    public int rob(TreeNode root) {
        if(root==null) return 0;
        if (memo.containsKey(root)) {
            return memo.get(root);
        }
        int m1= rob(root.left)+rob(root.right);
        int m2= root.val + ((root.left==null)?0:rob(root.left.left)+rob(root.left.right)) + ((root.right==null)?0:rob(root.right.right)+ rob(root.right.left));
        int maxMoney = Math.max(m1, m2);
        memo.put(root, maxMoney);
        return maxMoney;


    }
}