/*
Problem Link: https://practice.geeksforgeeks.org/problems/kth-largest-element-in-bst/1

Problem Statement: Given a Binary Search Tree. Your task is to complete the function which will return the Kth largest element without doing any modification in Binary Search Tree.

Solution Approach: 
Traverse the tree in an inorder fashion. But traverse the right node first, then node data, and then left node, so in order to get the
reversed order of the BST.

*/

/* ------------CODE---------------- */

//User function Template for Java

/*
class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class Solution
{
    // return the Kth largest element in the given BST rooted at 'root'
    int count;
    int num;
    public int kthLargest(Node root,int k)
    {
        count = 0;
        helper(root, k);
        return num;
    }
    
    private void helper(Node root, int k) {
        if(root==null)
        return;
        
        helper(root.right, k);
        count++;
        if(count==k)
            num = root.data;
        helper(root.left, k);
        
    }
}
/*
Time Complexity: O(n)
Space Complexity: O(H) where H is max recursion stack of height H at a given time.
*/