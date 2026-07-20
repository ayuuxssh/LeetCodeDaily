/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lca(root,p,q);
    }
    private TreeNode lca(TreeNode root,TreeNode p,TreeNode q)
    {
        if(root == null)
        {
            return root;
        }
       if(root ==p )
       {
        return p;
       }
       if(root == q)
       {
        return q;
       }
        TreeNode left = lca(root.left,p,q);
        TreeNode right = lca(root.right,p,q);
        if(left != null  && right!= null)
        {
            return root;
        }
        if(left!=null && right==null)
        {
            return left;
        }
        else
        {
            return right;
        }
       
    }
}