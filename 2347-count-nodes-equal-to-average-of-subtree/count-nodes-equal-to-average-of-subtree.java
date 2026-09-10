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
    public int averageOfSubtree(TreeNode root) {
        int []count = new int[1];
        int []ans = solve(root,count);
        return count[0];
    }
    private int[] solve(TreeNode root,int []count)
    {
        if(root == null)
        {
            return new int[]{0,0};
        }

        int [] left = solve(root.left,count);
        int []right = solve(root.right,count);
        int sum = left[0]+right[0]+root.val;
        int n = left[1]+right[1]+1;
        if(sum/n == root.val)
        {
            count[0]++;
        }
        return new int[]{sum,n};
    }
}