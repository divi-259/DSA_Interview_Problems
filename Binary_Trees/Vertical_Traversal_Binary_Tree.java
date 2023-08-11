/*
Problem Link: https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/ 


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
class Tuple {
    TreeNode node;
    int row;
    int col;
    public Tuple(TreeNode node, int row, int col) {
        this.node = node;
        this.row = row; // row represents the level of a node
        this.col = col; // col is like = -2 -1 0 +1 +2 = vertical ordering 
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        // this is the storage - Map<vertical, Map<level, Queue<nodes at that level>>

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root,0,0)); // root node has 0th level and it is at 0th vertical

        // we are traversing the tree in level order traversal and storing the nodes in our data structure

        while(!q.isEmpty()) {
            Tuple tp = q.remove();
            TreeNode node = tp.node;
            int r = tp.row;
            int c = tp.col;
            if(!map.containsKey(tp.col)) {
                map.put(c, new TreeMap<>());
            }
            if(!map.get(c).containsKey(r)) {
                map.get(c).put(r, new PriorityQueue<>());
            }
            map.get(c).get(r).offer(node.val);

            if(node.left!=null) {
                q.offer(new Tuple(node.left, r+1, c-1));
            }
            if(node.right!=null) {
                q.offer(new Tuple(node.right, r+1, c+1));
            }
        }

        // time to popoulate the answer
        List<List<Integer>> ans = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> vertical : map.values()) {
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> pq : vertical.values()) {
                while(!pq.isEmpty()) {
                    ans.get(ans.size()-1).add(pq.poll());
                }
            }
        }
        return ans;
        
    }
}