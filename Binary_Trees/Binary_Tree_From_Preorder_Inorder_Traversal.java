/*
Problem Link: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

Problem Statement: Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

Solution Approach: For inorder and (pre/postorder) traversals - the idea is same, we will get the root element from preorder or postorder array and keep dividing the inorder array based on this.
Keep a hashmap of the inorder array so as to know which part to take for recursion, also keeping the index for traversing preorder or postorder golbal will help

Simple code snippet for help:
{
if(left>right || preIndex<0)
return null; // We should not exceed the preorder array size - no elements left
TreeNode root = new TreeNode(postorder[preIndex]);
preIndex--;
// Now build left and right subtree
root.right = recurBuildTree(postorder, inorderIndexMap.get(rootValue)+1, right);
root.left = recurBuildTree(postorder, left, inorderIndexMap.get(rootValue)-1);
return root;
}

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
    int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        hmap = new HashMap<Integer, Integer>();
        for(int i=0; i<inorder.length; i++) {
            hmap.put(inorder[i], i); // to get the index of any node in inorder array
        }
        return helper(inorder, 0, inorder.length, preorder);
        
    }

    private TreeNode helper(int[] inorder, int left, int right, int[] preorder) {
        if(left>right || preIndex>=preorder.length)
            return null;
        TreeNode root = new TreeNode(preorder[preIndex]); // first element of preorder will give the root node
        int curr = preorder[preIndex];
        // populate left and right
        preIndex++;
        root.left = helper(inorder, left, hmap.get(curr)-1, preorder);
        root.right = helper(inorder, hmap.get(curr)+1, right, preorder);
        return root;
    }
}






/*
Other related problems: These below LC questions are related to each other - 

https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/

*/