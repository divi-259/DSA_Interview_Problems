/*
Problem Link: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/

Problem Statement: Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.

Solution Approach:
Visulaization is important in this question. 
We are taking the left node of the root, and we will go as far as there is a right node for this node.
Then we will attach the entire right subtree of the root after this rightmost point.
Then we move the entire left tree to the right tree, while making the left subtree as null
And in this way we will again move to the next right node and iteratively process each node and flatten the list.

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
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while(curr!=null) {
            if(curr.left!=null) {
                TreeNode last = curr.left;
                while(last.right!=null)
                    last = last.right; // keep going till the rightmost pointer
                // set curr.right at the last.right = flattening the right side of the list
                last.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }           

            curr = curr.right; // move forward with the next node on right  side
        }
               
    }
}