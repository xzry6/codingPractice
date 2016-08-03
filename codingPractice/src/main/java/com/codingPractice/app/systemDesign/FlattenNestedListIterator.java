package com.codingPractice.app.systemDesign;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class FlattenNestedListIterator implements Iterator<Integer> {
	List<Integer> list;
    int index;

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        this.list = new ArrayList<Integer>();
        this.index = 0;
        recursive(nestedList);
    }

    private void recursive(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.size() == 0) return;
        for(NestedInteger nested:nestedList) {
            if(nested.isInteger()) list.add(nested.getInteger());
            else recursive(nested.getList());
        }
    }

    @Override
    public Integer next() {
        if(index >= list.size()) return null;
        else return list.get(index ++);
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }
}

class NestedIterator2 implements Iterator<Integer> {

    Stack<Iterator<NestedInteger>> stack;
    NestedInteger next;

    public NestedIterator2(List<NestedInteger> nestedList) {
        stack = new Stack<Iterator<NestedInteger>>();
        stack.push(nestedList.iterator());
    }

    @Override
    public Integer next() {
        return next != null ? next.getInteger() : null;
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()) {
            if(!stack.peek().hasNext()) stack.pop();
            else if((next = stack.peek().next()).isInteger()) return true;
            else stack.push(next.getList().iterator());
        }
        return false;
    }
}

class NestedInteger {

	int i;
	List<NestedInteger> list;

	public NestedInteger(int i) {
		this.i = i;
		this.list = new ArrayList<NestedInteger>();
	}

	public boolean isInteger() {
		return list == null || list.size() == 0;
	}
	
	public Integer getInteger() {
		return i;
	}
	
	public List<NestedInteger> getList() {
		return list;
	}
}
