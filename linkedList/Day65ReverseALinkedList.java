package linkedList;

import java.util.Scanner;

public class Day65ReverseALinkedList {
    private static class Node {
        int data;
        Node next;
    
        Node(int new_data) {
            data = new_data;
            next = null;
        }
    }
    
    private static class Solution {
        public Node reverseList(Node head) {
            Node curr = head, prev = null, next;
            
            while(curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            return prev;
        }
    }   
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node head = null, tail = null;
        int n = scanner.nextInt();

        for(int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            Node new_node = new Node(data);

            if(head == null) {
                head = new_node;
                tail = new_node;
            } else {
                tail.next = new_node;
                tail = new_node;
            }
        }

        Solution solution = new Solution();
        Node new_head = solution.reverseList(head);
        while(new_head != null) {
            System.out.print(new_head.data + " ");
            new_head = new_head.next;
        }
        System.out.println();

        scanner.close();
    }
}
