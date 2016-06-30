package dataStructure;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LRUcache {
	private class Node {
        int key;
        int value;
        Node next;
        Node previous;
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            next = null;
            previous = null;
        }
    }
    
    private int capacity;
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;
    
    // @param capacity, an integer
    public LRUcache(int capacity) {
        // write your code here
        this.capacity = capacity;
        this.map = new HashMap<Integer, Node>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.previous = head;
    }

    // @return an integer
    public int get(int key) {
        // write your code here
        if(!map.containsKey(key))
            return -1;
            
        Node node = map.get(key);
        node.previous.next = node.next;
        node.next.previous = node.previous;
        
        node.next = head.next;
        head.next = node;
        node.next.previous = node;
        node.previous = head;
        
        return node.value;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // write your code here
        if(!map.containsKey(key)) {
            if(map.size() == capacity) {
            		Node previous = tail.previous;
                tail.previous = previous.previous;
                tail.previous.next = tail;
                map.remove(previous.key);
            }
        } else {
            Node node = map.get(key);
            Stack<Integer> stack = new Stack<Integer>();
            node.previous.next = node.next;
            node.next.previous = node.previous;
        }
        Node newNode = new Node(key, value);

        newNode.next = head.next;
        head.next = newNode;
        newNode.next.previous = newNode;
        newNode.previous = head;
        
        map.put(key, newNode);
    }
    
    public static void main(String[] args) {
    		LRUcache lru = new LRUcache(2);
    		lru.set(2, 1);
    		lru.set(1, 1);
    		System.out.println(lru.get(2));
    		lru.set(4, 1);
    		System.out.println(lru.get(1));
    		System.out.println(lru.get(2));
    }
}
