package com.codingPractice.app.googleCoding.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LRUCache {
	public static void main(String[] args) {
		LRUCache lru = new LRUCache(2);
		lru.set(2, 3);
		lru.set(1, 1);
		System.out.println(lru.get(2));
		lru.set(4, 2);
		System.out.println(lru.get(1));
		System.out.println(lru.get(4));
	}
	// Subclass.
    class Node {
        int key;
        int value;
        Node next;
        Node pre;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.pre = null;
        }
    }

    // Properties.
    Node head;
    Node tail;
    // Node tail.
    Map<Integer, Node> map;
    // Capacity.
    int capacity;

    // @param capacity, an integer
    public LRUCache(int capacity) {
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
        //this.tail = new Node(-1, -1);
        this.map = new HashMap<Integer, Node>();

        this.capacity = capacity;
    }

    // @return an integer
    public int get(int key) {
        // Return -1 if not exists.
        if(!map.containsKey(key)) {
            return -1;
        }
        // Move cur to the top;
        Node cur = map.get(key);
        switchToTop(cur, true);

        // Return.
        return cur.value;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        if(map.containsKey(key)) {
            Node cur = map.get(key);
            cur.value = value;
            switchToTop(cur, true);
        } else {
        		if(map.size() == capacity) {
        			map.remove(tail.pre.key);
        			tail.pre = tail.pre.pre;
        			tail.pre.next = tail;
        		}
            Node cur = new Node(key, value);
            map.put(key, cur);
            switchToTop(cur, false);
        }
    }

    // Private method.
    private void switchToTop(Node node, boolean isOld) {
    		if(isOld) {
    			node.pre.next = node.next;
        		node.next.pre = node.pre;
    		}
    		node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
        StringBuilder sb = new StringBuilder();
        List[] arr = new ArrayList[1];
        int[] arrr = new int[2];
    }
}
