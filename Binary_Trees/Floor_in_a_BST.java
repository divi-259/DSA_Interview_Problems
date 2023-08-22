/*
Problem Link: https://www.codingninjas.com/studio/problems/floor-from-bst_920457

Problem Statement: Given a BST and a node with value x, return the smallest node that is less than or equal to node with val x

Solution Approach: 
Traverse the tree in inorder fashion, and keep updating the value which is less than the value x, at the
end we will have the value in the ans that is just less than x.
*/

/* ------------CODE---------------- */

import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T>
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/

public class Solution {

    static int ansNode = -1;
    public static int floorInBST(TreeNode<Integer> root, int x) {
        helper(root, x);
        return ansNode;
    }

    private static void helper(TreeNode<Integer> root, int x) {
        if(root==null)
            return;
        // Traversing the tree in inorder fashion
        helper(root.left, x);
        if(root.data<=x)
        {
            ansNode = root.data;
        }
        helper(root.right, x);
        return;
    }
}
/*
Time Complexity: O(n) - might need to traverse all nodes
Space Complexity: O(h) - recursive stack space
*/