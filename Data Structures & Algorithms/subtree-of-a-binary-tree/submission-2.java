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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null && subRoot==null)
            return true;

        if(root==null || subRoot==null)
            return false;

        if(root.val==subRoot.val)
        {
            boolean ans = isSame(root,subRoot);

            if(ans)
                return ans;
        }
        boolean l = isSubtree(root.left, subRoot);
        boolean r = isSubtree(root.right,subRoot);


        return l||r;

    }

    public boolean isSame(TreeNode root, TreeNode subRoot){
        if(root==null && subRoot==null)
            return true;

        if(root==null || subRoot==null)
            return false;

        if(!(root.val == subRoot.val))
            return false;

        boolean l = isSame(root.left, subRoot.left);
        boolean r = isSame(root.right, subRoot.right);

        return l&&r;
    }
}
