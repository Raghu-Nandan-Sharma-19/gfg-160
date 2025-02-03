package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Day81HeightOfBinaryTree {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
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
        Solution s = new Solution();
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        
        System.out.println(s.levelOrder(root));
    }
}
