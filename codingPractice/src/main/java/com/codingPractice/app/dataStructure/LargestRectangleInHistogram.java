package com.codingPractice.app.dataStructure;

import java.util.Stack;

public class LargestRectangleInHistogram {
	public int largestRectangleArea(int[] height) {
        // write your code here
        if(height == null || height.length == 0) return 0;
		Stack<Integer> stack = new Stack<Integer>();
	    int max = 0;
	    for (int i = 0; i <= height.length; i++) {
	        int curt = (i == height.length) ? -1 : height[i];
	        while (!stack.isEmpty() && curt <= height[stack.peek()]) {
	            int h = height[stack.pop()];
	            int w = stack.isEmpty() ? i : i - stack.peek() - 1;
	            max = Math.max(max, h * w);
	        }
	        stack.push(i);
	    }
	    
	    return max;
	}
	
	public static void main(String[] args) {
		int[] arr = {5,4,1,2};
		System.out.println(new LargestRectangleInHistogram().largestRectangleArea(arr));
	}
}
