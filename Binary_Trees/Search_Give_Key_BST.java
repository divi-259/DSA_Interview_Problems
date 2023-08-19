/*
Problem Link: https://leetcode.com/problems/search-in-a-binary-search-tree/

Problem Statement: You are given the root of a binary search tree (BST) and an integer val.

Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.

Solution Approach: Traverse the tree in a manner of finding the key, if it is smaller go left side, if larger go right side, if
key not found return null, otherwise return the node where the key is found.

*/

/* ------------CODE---------------- */
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
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null)
        return null;

        if(root.val==val)
        return root;

        if(val < root.val)
        return searchBST(root.left, val);

        else return searchBST(root.right, val);
    }
}

/*
Time Complexity: O(logn) - we will travers till the height of the tree
Space Complexity: O(logn) - recursive calls in stack can go as far as height of the tree
*/