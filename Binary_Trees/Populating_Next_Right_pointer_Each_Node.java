/*
Problem Link: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

Problem Statement: You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. 
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Solution Approach: BFS will rescue here, keep processing elements if the queue is not empty, for every last element at the current level
we make its next pointer point to null.

*/

/* ------------CODE---------------- */
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {

        Queue<Node> q = new LinkedList<Node>();
        if(root==null)
        return null;

        if(root.left == null && root.right ==null)
        {
            root.next = null;
            return root;
        }
        q.offer(root);

        while(!q.isEmpty()) {
            int level = q.size();
            for(int i=0; i<level; i++) {
                Node temp = q.poll();
                if(i==level-1) 
                {
                    temp.next = null;
                }
                else {
                    Node tnext = q.peek();
                    temp.next = tnext;
                }
                if(temp.left!=null) q.offer(temp.left);
                if(temp.right!=null) q.offer(temp.right);
            }

        }
        return root;        
    }
}

/*
Time Complexity: 
Space Complexity: 
*/