/*
Problem Link: https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

Problem Statement: Given the root of a binary search tree and an integer k, return true if there exist two elements in the BST such that their sum is equal to k, or false otherwise.

Solution Approach: 
Using set while traversing the tree is a good way to keep track of the already traversed elements.
We can check in the set if we have k-currnode and return true.

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
    HashSet<Integer> hset;
    public boolean findTarget(TreeNode root, int k) {
        
        hset = new HashSet<>();
        return helper(root, k);
    }

    private boolean helper(TreeNode root, int k) {

        if(root==null)
        return false;

        boolean l = helper(root.left,k);
        if(hset.contains(k-root.val))
        return true;
        hset.add(root.val);
        boolean r = helper(root.right, k);

        return (l || r);

    }
}
/*
Time Complexity: O(n)
Space Complexity: O(n) - might need to store a lot of node values
*/