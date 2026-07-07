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
    int goodnodes=0;
    public int goodNodes(TreeNode root) {

        int count = dfs(root, root.val);
        return count;
        
    }

    public int dfs(TreeNode root, int max){
        if(root==null)
            return 0;

        int count = (root.val>=max)? 1: 0;//for current node

        if(root.val>max)
            max=root.val;
        
        int l = dfs(root.left, max);
        int r = dfs(root.right,max);

        return l+r+count;

    }
}
