package dataStructure;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {
	Queue<Integer> q = new LinkedList<Integer>();
	
	// Push element x onto stack.
    public void push(int x) {
    		q.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
    		top();
    		q.poll();
    }

    // Get the top element.
    public int top() {
    		if(!q.isEmpty())
    			for(int i=0; i<q.size()-1; ++i)
    				q.add(q.poll());
    		return q.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
    		return q.isEmpty();
    }
    
    public static void main(String[] args) {
    		ImplementStackUsingQueues isuq = new ImplementStackUsingQueues();
    		isuq.push(1);
    		isuq.push(2);
    		isuq.push(3);
    		System.out.println(isuq.top());
    }
}
