package linkedList;

import java.util.Scanner;

public class Day70CloneListWithNextAndRandom {
    private static class Node {
        int data;
        Node next, random;

        Node(int d) {
            data = d;
            next = random = null;

        }
    }

    private static class Solution {
        public Node cloneLinkedList(Node head) {
            if(head == null) {
                return null;
            }
            
            Node curr = head;
            while(curr != null) {
                Node newNode = new Node(curr.data);
                newNode.next = curr.next;
                curr.next = newNode;
                curr = newNode.next;
            }
            
            curr = head;
            while(curr != null) {
                if(curr.random != null) {
                    curr.next.random = curr.random.next;
                }
                curr = curr.next.next;
            }
            
            curr = head;
            Node clonedHead = head.next;
            Node clone = clonedHead;
            while(clone.next != null) {
                curr.next = curr.next.next;
                clone.next = clone.next.next;
                
                curr = curr.next;
                clone = clone.next;
            }
            curr.next = null;
            clone.next = null;
            
            return clonedHead;
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
        
        Node curr = head;
        Node random = head;
        while(curr != null) {
            int randomIndex = scanner.nextInt();
            if(randomIndex != -1) {
            Node temp = head;
            for (int i = 0; i < randomIndex; i++) {
                temp = temp.next;
            }
            random = temp;
            }
            curr.random = random;
            curr = curr.next;
        }

        Solution solution = new Solution();
        Node clonedHead = solution.cloneLinkedList(head);
        
        boolean isIdentical = true;
        Node original = head;
        Node clone = clonedHead;
        while(original != null && clone != null) {
            if(original.data != clone.data || (original.random != null && clone.random != null && original.random.data != clone.random.data)) {
            isIdentical = false;
            break;
            }
            original = original.next;
            clone = clone.next;
        }
        
        if(original != null || clone != null) {
            isIdentical = false;
        }
        
        System.out.println(isIdentical);
        scanner.close();

        scanner.close();
    }
}
