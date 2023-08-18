/*
Problem Link: https://www.codingninjas.com/studio/problems/children-sum-property_8357239?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf


Problem Statement: Return true if all the non leaf nodes in the binary tree have a value that is equal to the sum of their left and right child nodes

Solution Approach: recursively call the helper method on both and left subtree of the root node, and check if the sum value is equal to the root's value
Also return the root's value for it to become the answer for the previous recursive call of the stack.
For nodes with null value - return 0 as the value.

*/
public class Solution {
    static boolean isPossible;
    public static boolean isParentSum(Node root) {
        // Write your code here.
        isPossible = true;
        if(root==null)
        return true;
        
        int ans = helper(root);
        return isPossible;
    }

    private static int helper(Node root) {
        if(root==null)
        return 0;
        if(root.left==null && root.right==null)
        return root.data;

        int left = helper(root.left);
        int right = helper(root.right);

        if(left + right != root.data)
            isPossible = false;
        return root.data;
    }
}