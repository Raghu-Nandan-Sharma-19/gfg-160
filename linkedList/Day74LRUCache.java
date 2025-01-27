package linkedList;

import java.util.*;

public class Day74LRUCache {
    private static class Solution {
        private class Node {
            int key, value;
            Node prev, next;
            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
        
        private Map<Integer, Node> cache;  
        private int capacity;
        private Node head, tail;

        public Solution(int cap) {
            this.capacity = cap;
            cache = new HashMap<>();
            
        
            head = new Node(0, 0);
            tail = new Node(0, 0);
            
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            Node node = cache.get(key);
            if (node == null) return -1; 
            
            moveToFront(node);
            return node.value;
        }

    
        public  void put(int key, int value) {
            Node node = cache.get(key);
            
            if (node != null) {
                node.value = value;
                moveToFront(node);
            } else {
                if (cache.size() >= capacity) {
                    removeLeastUsed();
                }
                Node newNode = new Node(key, value);
                cache.put(key, newNode);
                addToFront(newNode);
            }
        }
        
        private void moveToFront(Node node) {
            removeNode(node);
            addToFront(node);
        }
        
        private void addToFront(Node node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }
        
        private void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        
        private void removeLeastUsed() {
            Node leastUsed = tail.prev;
            removeNode(leastUsed);
            cache.remove(leastUsed.key);
        }
    }

    public static void main(String[] args) {
        Solution cache = new Solution(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);                        // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);                        // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}
