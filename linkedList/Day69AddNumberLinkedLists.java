package linkedList;

import java.util.Scanner;

public class Day69AddNumberLinkedLists {
    private static class Node {
        int data;
        Node next;
    
        Node(int d) {
            data = d;
            next = null;
        }
    }

    private static class Solution {
        public static Node reverse(Node head) {
            Node curr = head;
            Node prev = null;
            Node next = null;
            
            while(curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            
            return prev;
        }
        
        public Node addTwoLists(Node num1, Node num2) {
            int carry = 0;
            
            Node rev1 = reverse(num1);
            Node rev2 = reverse(num2);
            
            Node head = null;
            Node tail = head;
            
            while(rev1 != null || rev2 != null || carry != 0) {
                int val1 = 0;
                int val2 = 0;
                if(rev1 != null) val1 = rev1.data;
                if(rev2 != null) val2 = rev2.data;
                
                int sum = val1 + val2 + carry;
               
                int digit = sum % 10;
                carry = sum / 10;
                Node temp = new Node(digit);
                
                if(head == null) {
                    head = temp;
                    tail = temp;
                } else {
                    tail.next = temp;
                    tail = temp;
                }
                
                if(rev1 != null) rev1 = rev1.next;
                if(rev2 != null) rev2 = rev2.next;
            }
            
            
            Node result = reverse(head);
            
            while(result != null) {
                if(result.data != 0) break;
                result = result.next;
            }
            
            return result;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        
        Node head1 = null;
        Node tail1 = head1;
        for(int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            Node temp = new Node(data);
            if(head1 == null) {
                head1 = temp;
                tail1 = temp;
            } else {
                tail1.next = temp;
                tail1 = temp;
            }
        }

        Node head2 = null;
        Node tail2 = head2;
        for(int i = 0; i < m; i++) {
            int data = scanner.nextInt();
            Node temp = new Node(data);
            if(head2 == null) {
                head2 = temp;
                tail2 = temp;
            } else {
                tail2.next = temp;
                tail2 = temp;
            }
        }

        Solution solution = new Solution();
        Node result = solution.addTwoLists(head1, head2);
        while(result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }

        scanner.close();
    }
}
