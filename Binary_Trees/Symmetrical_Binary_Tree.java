/*
Problem Link: https://leetcode.com/problems/symmetric-tree/

Problem Statement: Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

Solution Approach: In this problem we are mainly concerned if root.left == root.right for every node, and this is what we will check 

*/

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
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
        return true;
        return isMirror(root.left, root.right);        
    }

    private boolean isMirror(TreeNode root1, TreeNode root2) {

        if(root1==null && root2==null)
        return true;

        else if(root1!=null && root2!=null && root1.val==root2.val && isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left))
            return true;
        else return false; 


    }
}