package linkedList;

public class Day73RemoveLoopInLinkedList {
    private static class Node {

        int data;
        Node next;
    
        Node(int x) {
            data = x;
            next = null;
        }
    }

    private static class Solution {
        public void printList(Node head) {
            Node temp = head;
            while(temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }

        public void removeLoop(Node head) {
            if(head == null || head.next == null) return;
                
            Node slow = head, fast = head;
            slow = slow.next;
            fast = fast.next.next;
            
            while(fast != null && fast.next != null) {
                if(slow == fast) break;
                slow = slow.next;
                fast = fast.next.next;
            }
            
            if(slow == fast) {
                slow = head;
                if (slow != fast) {
                    while (slow.next != fast.next) {
                        slow = slow.next;
                        fast = fast.next;
                    }
                  
                     fast.next = null; 
                } else {
                    while(fast.next != slow) {
                        fast = fast.next;
                    }
                    fast.next = null;
                }
            }

            System.out.println("Loop present at: " + slow.data);
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(4);

        // Creating a loop for testing
        head.next.next.next = head.next;
        
        Solution sol = new Solution();
        sol.removeLoop(head);
        sol.printList(head);
    }
}
