package linkedList;

import java.util.Scanner;
import java.util.Stack;

public class Day68LinkedListGroupReverse {
    private static class Node {
        int data;
        Node next;

        Node(int key) {
            data = key;
            next = null;
        }
    }
    
    private static class Solution {
        public Node reverseKGroup(Node head, int k) {
            if(head == null || k == 1) {
                return head;
            }
            
            Stack<Node> st = new Stack<>();
            Node curr = head;
            Node prev = null;
            
            while(curr != null) {
                int count = 0;
                while(curr != null && count < k) {
                    st.push(curr);
                    curr = curr.next;
                    count++;
                }
                
                while(!st.isEmpty()) {
                    if(prev == null) {
                        prev = st.pop();
                        head = prev;
                    } else {
                        prev.next = st.pop();
                        prev = prev.next;
                    }
                }
            }
            
            prev.next = null;
            
            return head;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node head = new Node(scanner.nextInt());
        Node tail = head;
        
        for(int i = 0; i < n - 1; i++) {
            tail.next = new Node(scanner.nextInt());
            tail = tail.next;
        }

        int k = scanner.nextInt();

        Solution solution = new Solution();
        head = solution.reverseKGroup(head, k);
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }

        scanner.close();
    }
}
