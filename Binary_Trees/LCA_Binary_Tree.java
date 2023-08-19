/*
Problem Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

Problem Statement: Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Solution Approach: use recursion to find the LCA of node p and q, as it is a BST - we can check the base condition at every recursion call

*/

/* ------------CODE---------------- */
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

        if(p.val==root.val || q.val==root.val)
        return root;

        if(root.val > p.val && root.val>q.val)
        return lowestCommonAncestor(root.left, p, q);

        if(root.val < p.val && root.val<q.val)
        return lowestCommonAncestor(root.right, p, q);

        return root;

        
    }

}

/*
Time Complexity: O(h)
Space Complexity: O(h)
*/