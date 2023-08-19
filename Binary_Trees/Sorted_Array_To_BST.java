/*
Problem Link: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

Problem Statement: Given an integer array nums where the elements are sorted in ascending order, convert it to a 
height-balanced binary search tree.

Solution Approach: Keep dividing the array into two halves, take middle as root, and update left and right child of root by recursively calling the function.

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
    public TreeNode sortedArrayToBST(int[] nums) {
        
    if(nums.length==0)
        return null;
    TreeNode head = helper(nums,0,nums.length-1);
    return head;
        
    }
    
    private TreeNode helper(int[] nums, int low, int high) {
        if(low>high)
            return null;
        int mid = (low+high)/2; // Root node will always be in the middle
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums,low, mid-1);
        node.right = helper(nums, mid+1, high);
        return node;
        
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(n)
*/