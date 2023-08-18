
/*
Problem Link: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/

Problem Statement: Given two integer arrays postorder and inorder where preorder is the postorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

Solution Approach: For inorder and (pre/postorder) traversals - the idea is same, we will get the root element from preorder or postorder array and keep dividing the inorder array based on this.
Keep a hashmap of the inorder array so as to know which part to take for recursion, also keeping the index for traversing preorder or postorder golbal will help

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
    HashMap<Integer, Integer> hmap;
    int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        hmap = new HashMap<>();
        postIndex = postorder.length-1;

        for(int i=0; i<inorder.length; i++) {
            hmap.put(inorder[i], i); // to get the exact indices of left and right subtrees in inorder array
        }
        return helper(postorder, 0, postorder.length-1);
    }

    private TreeNode helper(int[] postorder, int left, int right) {
        if(postIndex <0 || left>right)
            return null;
        int curr = postorder[postIndex];
        TreeNode root = new TreeNode(curr);

        postIndex--;
        // we will build the right node first then the left node as it is getting built from postorder traversal        
        root.right = helper(postorder, hmap.get(curr)+1, right);
        root.left = helper(postorder, left, hmap.get(curr)-1);

        return root;

    }
}