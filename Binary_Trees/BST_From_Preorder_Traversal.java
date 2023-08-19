/*
Problem Link: https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

Problem Statement: Given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree), construct the tree and return its root.
It is guaranteed that there is always possible to find a binary search tree with the given requirements for the given test cases.
A binary search tree is a binary tree where for every node, any descendant of Node.left has a value strictly less than Node.val, and any descendant of Node.right has a value strictly greater than Node.val.
A preorder traversal of a binary tree displays the value of the node first, then traverses Node.left, then traverses Node.right.

Solution Approach: 
The idea is to use the stack to reach to the node on whose right side we want to update.
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
    // preIndex to traverse the preorder array from left to right direction
    private int preIndex;
    // Stack to keep track of all the nodes created and pushed
    Stack<TreeNode> st;
    public TreeNode bstFromPreorder(int[] preorder) {
        preIndex = 0;
        st = new Stack<>();
        return helper(preorder);
    }

    private TreeNode helper(int[] preorder) {
        if(preIndex >= preorder.length)
        return null;

        TreeNode root = new TreeNode(preorder[preIndex]);
        st.push(root);
        preIndex++;
        
        // if this is the case keep adding to the left of the root
        if(preIndex < preorder.length && preorder[preIndex] < root.val)
        root.left = helper(preorder);

        // otherwise we will get the correct node from the stack on whose right we should be putting the next node of the preorder array
        if(preIndex < preorder.length && preorder[preIndex] > root.val)
        {
            TreeNode temp = null;
            // get the node from the stack
            while(!st.isEmpty() && st.peek().val < preorder[preIndex])
            {
                temp = st.pop();
            }
            // update the right of this node
            temp.right = helper(preorder);
        }
        // we will only return root, as that is the node we created at first place and all others we are just populating recursively
        return root;
    }
}

/*
Time Complexity: 
Space Complexity: 
*/