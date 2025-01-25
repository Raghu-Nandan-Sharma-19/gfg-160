package linkedList;

public class Day72FindTheFirstLoopOfNodeInLinkedList {
    private static class Node {
        int data;
        Node next;
        Node(int x) {
            data = x;
            next = null;
        }
    }

    private static class Solution {
        public Node findFirstNode(Node head) {
            Node slow = head;
            Node fast = head;
            
            while(fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if(slow == fast) {
                    slow = head;
                    
                    while(slow != fast) {
                        slow = slow.next;
                        fast = fast.next;
                    }
                    
                    return slow;
                }
            }
            
            return null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(2);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        head.next.next.next.next = head;

        Solution sol = new Solution();
        Node loopNode = sol.findFirstNode(head);

        if (loopNode != null)
            System.out.println(loopNode.data);
        else
            System.out.println(-1);
    }
}
