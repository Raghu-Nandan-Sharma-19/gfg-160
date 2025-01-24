package linkedList;

import java.util.Scanner;

public class Day71DetectLoopInLinkedList {
    private static class Node {
        int data;
        Node next;

        Node(int d) {
            this.data = d;
            this.next = null;
        }
    }

    private static class Solution {
        public static boolean detectLoop(Node head) {
            Node slow = head, fast = head;
            
            while(slow != null && fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                
                if(slow == fast) {
                    return true;
                }
            }
            
            return false;
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

        int pos = scanner.nextInt();
        if(pos != -1) {
            Node temp = head;
            for(int i = 0; i < pos; i++) {
                temp = temp.next;
            }
            tail.next = temp;
        }

        if(Solution.detectLoop(head)) {
            System.out.println("Loop found");
        } else {
            System.out.println("No loop");
        }

        scanner.close();
    }
}
