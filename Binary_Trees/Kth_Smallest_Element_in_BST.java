/*
Problem Link: https://leetcode.com/problems/kth-smallest-element-in-a-bst/

Problem Statement: Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

Solution Approach: Inorder traverse the tree, and keep a counter count, increase its value in every traversal,
as soon as it reaches k - set the ans value to the current node's data.
return ans value in main method

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
    private int res;
    private int count = 0;
    public int kthSmallest(TreeNode root, int k) {

        helper(root, k);
        return res;
        
    }
    private void helper(TreeNode root, int k) {
        if(root==null)
        return;

        // inorder fashion traversal
        helper(root.left, k);
        count++;
        if(count==k)
            res = root.val;
        helper(root.right,k);
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(h)
*/