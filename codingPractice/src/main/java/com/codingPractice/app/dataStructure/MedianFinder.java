package com.codingPractice.app.dataStructure;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class MedianFinder {

	private Comparator<Double> rorder = new Comparator<Double>() {
		public int compare(Double o1, Double o2) {
			return (int) (o2-o1);
		}
	};
	
	private PriorityQueue<Double> left = new PriorityQueue<Double>(10000, rorder);
	private PriorityQueue<Double> right = new PriorityQueue<Double>(10000);
	private double median = Double.MIN_VALUE;
	private boolean even = true;
	
    // Adds a number into the data structure.
    public void addNum(int num) {
    		even = !even;
    		if(median == Double.MIN_VALUE) {
    			median = num;
    			return;
    		}
    		if(num < median) {
    			left.add((double)num);
    			if(even) {
    				right.add(median);
    				median = (left.peek()+right.peek())/2;
    			} else median = left.poll();
    		}
    		else {
    			right.add((double)num);
    			if(even) {
    				left.add(median);
    				median = (left.peek()+right.peek())/2;
    			} else median = right.poll();
    		}

    }

    // Returns the median of current data stream
    public double findMedian() {
    		return median;
    }
    
    public static void main(String[] args) {
//    		MedianFinder mf = new MedianFinder();
//    		mf.addNum(0);
//    		mf.addNum(1);
//    		mf.addNum(5);
//    		System.out.println(mf.findMedian());
//    		System.out.println('1'-48);
    		Queue<Integer> queue = new LinkedList<Integer>();
    		queue.offer(null);
    		System.out.println(queue.isEmpty());
    		System.out.println(queue.poll());
    		Stack<Integer> stack = new Stack<Integer>();
    		PriorityQueue<Integer> q = new PriorityQueue<Integer>();

    }
}
