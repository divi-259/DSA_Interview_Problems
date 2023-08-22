/*
Problem Link: https://www.codingninjas.com/studio/problems/ceil-from-bst_920464

Problem Statement: Return ceil value of a given integer in BST

Solution Approach: We will do the same inorder traversal as we did for the floor question.
We will return as soon as we reach the first ans.

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

    static int ceilVal;
    public  static int findCeil(TreeNode<Integer> node, int x) {

        // Write your code here
        ceilVal = -1;
        helper(node, x);
        return ceilVal;

    }

    private static void helper(TreeNode<Integer> root, int x) {
        if(root==null)
        return;
        helper(root.left, x);
        if(ceilVal==-1 && root.data>=x)
        {
            ceilVal = root.data;
            return;
        }
        helper(root.right, x);
        //return;
    }
}


/*
Time Complexity: O(n)
Space Complexity: O(h) - h is the height of the tree
*/