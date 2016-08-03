package com.codingPractice.app.dataStructure;

public class MinStack {
	
	Node head = null;
	
	public void push(int x) {
        if(head==null) {
        	head = new Node(x);
        	head.min = x;
        }else {
        	Node temp = new Node(x);
        	temp.next = head;
        	head = temp;
        	head.min = Math.min(x, head.next.min);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
    	return head.val;
    }

    public int getMin() {
        return head.min;
    }
}
class Node {
	int val;
	int min;
	Node next;
	Node(int val) {
		this.val = val;
	}
}
