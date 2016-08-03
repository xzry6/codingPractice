package com.codingPractice.app.acmcoder;

import java.util.HashSet;
import java.util.Set;

class Node {
	int value;
	Node next;
	Node below;

	Node(int value) {
		this.value = value;
		this.next = null;
		this.below = null;
	}
}

public class FindNodes {

	public static void main(String[] args) {
		Node a = new Node(8);
		Node b = new Node(28);
		Node c = new Node(52);
		Node d = new Node(25);
		Node e = new Node(81);
		Node f = new Node(5);
		Node g = new Node(33);
		Node h = new Node(55);
		Node i = new Node(70);
		Node j = new Node(83);
		a.below = b;
		b.below = d;
		b.next = c;
		c.below = e;
		d.next = e;
		d.below = f;
		e.below = g;
		f.next = g;
		g.next = h;
		h.next = i;
		i.next = j;
		System.out.println(searchNodes(a, 55));
	}
	static Set<Node> set = new HashSet<Node>();
	static int searchNodes(Node root, int value) {
        // Deal with null and empty cases first.
        if(root == null) return -1;
        if(set.contains(root)) return -1;
        if(root.value == value) {
        		return 0;
        }
        set.add(root);
        // Recursive and get minimum path.
        int right = searchNodes(root.next, value);
        int bottom = searchNodes(root.below, value);
        // Return.
        if(right == -1 && bottom == -1) return -1;
        if(right == -1) return bottom + 1;
        if(bottom == -1) return right + 1;
        return Math.min(right, bottom) + 1;
    }
}


