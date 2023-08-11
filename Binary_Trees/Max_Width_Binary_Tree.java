/*

Problem Link: https://leetcode.com/problems/maximum-width-of-binary-tree/
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

/*
Solution approach: Traverse the tree in level order manner, and for each node maintain its width from the root node
for every level - keep the left and right most node saved, 
and use the distance between them to find out the max distance so far
*/
class Solution {
    public int widthOfBinaryTree(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();

        if(root==null)
        return 0;

        q.offer(root);
        map.put(root, 1);

        int maxWidth = 0;

        while(!q.isEmpty()) {
            int level = q.size();
            int left=0, right=0;

            for(int i=0; i<level; i++) {
                TreeNode temp = q.poll();
                if(i == 0) left = map.get(temp);
                if(i == level - 1) right = map.get(temp);
                if(temp.left!=null) { 
                    map.put(temp.left, map.get(temp)*2);
                    q.offer(temp.left);
                    }
                if(temp.right!=null){ 
                    q.offer(temp.right);
                    map.put(temp.right, map.get(temp)*2+1);
                    }
            }

            if(maxWidth < (right-left+1))
            maxWidth = right-left+1;

        }
        return maxWidth;

        
    }
}