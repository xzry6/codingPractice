package com.codingPractice.app.array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a stream of integers and a window size,
 * calculate the moving average of all integers in the sliding window.
 * 
 * For example,
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 * 
 * @author Sean
 *
 */
public class MovingAverage {
	private int size;
    private int sum;
    private Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        this.sum = 0;
        this.queue = new LinkedList<Integer>();
    }
    
    public double next(int val) {
        if(!queue.isEmpty() && queue.size() == size)
            sum -= queue.poll();
        sum += val;
        queue.offer(val);
        return (double) sum / queue.size();
    }
}
