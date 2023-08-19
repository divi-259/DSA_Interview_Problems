/*
Problem Link: https://practice.geeksforgeeks.org/problems/predecessor-and-successor/1

Problem Statement: There is BST given with the root node with the key part as an integer only. You need to find the in-order successor and predecessor of a given key. If either predecessor or successor is not found, then set it to NULL.

Note:- In an inorder traversal the number just smaller than the target is the predecessor and the number just greater than the target is the successor. 

Solution Approach: Basic approach will be to get the inorder traversal and then return the prev and next element of the array.
We can do better by keeping a track of the prev and next element while traversing the tree in an inorder fashion, this 
will lead to space complexity taken up by the stack only - O(logn), and no extra space will be needed, worst case we might need to 
traverse all the elements in the array - so time complexity will be O(n)

*/

/* ------------CODE---------------- */
//Function to check whether a Binary Tree is BST or not.
public static void findPreSuc(Node root, int key)
{
    // code here.
    helper(root, key);
    
    /* There are two static nodes defined above pre(representing predecessor) and suc(representing successor) as follows:
       static Node pre=null,suc=null
       You need to update these both.
       And the data inside these classes will be printed automatically by the driver code. 
    */
}

private static void helper(Node root, int key) {
    
    if(root==null)
        return;
    
    // inorder traversal left node
    helper(root.left, key);
    
    // inorder traversal procssing data
    if(root.data < key && pre==null)
        pre = root;
    else if(root.data < key && pre!=null && root.data>pre.data)
        pre = root;
    else if(root.data > key && suc==null)
        suc = root;
    else if(root.data > key && suc!=null && root.data < suc.data)
        suc = root;
        
        
    // inorder traversal - right node
    helper(root.right, key);
    
    return;
    
    
}

/*
Time Complexity: O(n)
Space Complexity: O(logn)
*/