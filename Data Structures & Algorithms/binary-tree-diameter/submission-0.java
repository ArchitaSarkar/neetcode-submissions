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
    class diam{
        int ht,d;
        diam(int ht,int d){
            this.ht=ht;
            this.d=d;
        }
    }

    public diam calculate(TreeNode root)
    {
        if(root==null)
        {
            return new diam(0,0);
        }
        diam l=calculate(root.left);
        diam r=calculate(root.right);
        int h=Math.max(l.ht,r.ht)+1;
        int d=Math.max(Math.max(l.d,r.d),l.ht+r.ht);

        return new diam(h,d);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        diam res=calculate(root);
        return res.d;
    }
}