/*
Problem Link: https://practice.geeksforgeeks.org/problems/mirror-tree/1

Problem Statement: Given a Binary Tree, convert it into its mirror.

Solution Approach: Keep the approach simple, draw using pen and paper, and understand how things will work for every node.
For root we are just going to swap left tree with right tree using a temp variable, and then we are going to call this same helper 
method recursively for bothe left and right subtrees to keep applying the mirror property for all the subnodes of the tree.

*/


// User function Template for Java

// function Template for Java

// FUNCTION CODE
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)
   {
        data = item;
        left = right = null;
    }
} */

class Solution {
    // Function to convert a binary tree into its mirror tree.
    void mirror(Node node) {
        // Your code here
        if(node==null)
        return;
        
        helper(node);
    }
    
    void helper(Node root) {
        if(root==null)
        return;
        
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        helper(root.left);
        helper(root.right);
    }
}