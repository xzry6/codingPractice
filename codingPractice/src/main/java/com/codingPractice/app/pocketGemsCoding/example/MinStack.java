package com.codingPractice.app.pocketGemsCoding.example;

public class MinStack {
	
	 private Node top;
	    
	 public MinStack() {
	     // do initialize if necessary
		 top = new Node(0, Integer.MAX_VALUE);
	 }
	    
    private class Node {

        int val;
        int min;
        Node next;
        
        Node(int val, int min) {
            this.val = val;
            this.min = min;
            next = null;
        }
    }

    public void push(int number) {
        // write your code here
        if(top.next == null)
            top.next = new Node(number, number);
        else {
            int min = Math.min(top.next.min, number);
            Node node = new Node(number, min);
            Node tmp = top.next;
            top.next = node;
            node.next = tmp;
        }
    }

    public int pop() {
        // write your code here
        Node node = top.next;
        top.next = node.next;
        return node.val;
    }

    public int min() {
        // write your code here
        return top.next.min;
    }
}
