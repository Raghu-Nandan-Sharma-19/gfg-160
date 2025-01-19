package linkedList;

import java.util.Scanner;

public class Day66RotateALinkedList {
    private static class Node {
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }

    private static class Solution {
        private void printList(Node head) {
            Node curr = head;
            while(curr != null) {
                System.out.print(curr.data + " ");
                curr = curr.next;
            }
            System.out.println();
        }

        public Node rotate(Node head, int k) {
            if(head == null || head.next == null || k == 0) {
                return head;
            }
            
            Node curr = head;
            int len = 1;
            while(curr.next != null) {
                curr = curr.next;
                len++;
            }
            
            k = k % len;
            if(k == 0) {
                return head;
            }
    
            curr.next = head;
            Node newTail = head;
            for(int i = 1; i < len - k; i++) {
                newTail = newTail.next;
            }
    
            Node newHead = newTail.next;
    
            newTail.next = null;
    
            return newHead;
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

        int k = scanner.nextInt();

        Solution sol = new Solution();
        head = sol.rotate(head, k);
        sol.printList(head);

        scanner.close();
    }
}
