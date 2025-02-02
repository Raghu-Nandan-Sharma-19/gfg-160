package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Day80LevelOrderTraversal {
    class Node {
        int data;
        Node left, right;
    
        public Node(int item) {
            data = item;
            left = right = null;
        }
    }
    
    private static class Solution {
        public ArrayList<ArrayList<Integer>> levelOrder(Node root) {
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            ArrayDeque<Node> q = new ArrayDeque<>();
            
            q.offer(root);
            
            while (!q.isEmpty()) {
                int len = q.size();
                ArrayList<Integer> level = new ArrayList<>();
                
                
                while (len -- > 0) {
                    level.add(q.peek().data);
                    
                    if (q.peek().left != null) q.offer(q.peek().left);
                    
                    if (q.peek().right != null) q.offer(q.peek().right);
                    
                    q.poll();
                }
                
                ans.add(level);
            }
            
            return ans;
        }
    }
    public static void main(String[] args) {
        Day80LevelOrderTraversal tree = new Day80LevelOrderTraversal();
        Node root = tree.new Node(1);
        root.left = tree.new Node(3);
        root.right = tree.new Node(2);
        root.right.right = tree.new Node(4);
        root.right.right.left = tree.new Node(6);
        root.right.right.right = tree.new Node(5);

        // Perform level order traversal
        Solution sol =  new Solution();
        ArrayList<ArrayList<Integer>> res = sol.levelOrder(root);

        // Print the result
        for (ArrayList<Integer> level : res) {
            for (int data : level) {
                System.out.print(data + " ");
            }
        }
    }
}
