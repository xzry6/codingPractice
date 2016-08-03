package com.codingPractice.app.array;

import java.util.Arrays;

public class SortTransformedArray {
	/**
     * f(x) = ax^2 + bx + c
     * 
     *        |- 
     * f(x) = |- c  (x=0)
     *        |-
     * 
     * f(x) = a(x - b/2a)^2 + (4ac - b^2) / 4a
     *      = a*(x^2 - bx/a + b^2/4a^2) + (4ac - b^2) / 4a
     *      = ax^2 - bx + c
     * 
     *      |\  /
     *      | \/ (b/2a, (4ac - b^2) / 4a)
     * -----|-----------
     *      |
     *      |
     */ 
    public static int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        // Deal with empty first.
        if(nums == null || nums.length == 0) return nums;

        int[] results = new int[nums.length];

        if(a == 0) {
        		if(b > 0) {
        			for(int i = 0; i < results.length; ++ i)
        				results[i] = (int) (a * Math.pow(nums[i], 2) + b * nums[i] + c);
        		} else {
        			for(int i = results.length - 1; i >= 0; -- i)
        				results[i] = (int) (a * Math.pow(nums[results.length - 1 - i], 2) + b * nums[results.length - 1 - i] + c);
        		}
        		return results;
        }
        int breakPoint = (int) Math.round(- (double) b / (2 * a));
        // Find 2a/b.
        int index = 0;
        for(int i = 0; i < nums.length; ++ i) {
            if(nums[i] <= breakPoint || i > 0 && Math.abs(nums[i - 1] - breakPoint) > Math.abs(nums[i] - breakPoint)) index = i;
            else break;
        }

        // Two pointer.
        results[0] = (int) (a * Math.pow(nums[index], 2) + b * nums[index] + c);
        int p = 1;
        int p1 = index - 1;
        int p2 = index + 1;
        while(p1 >= 0 || p2 <= nums.length - 1) {
            long n1 = Integer.MAX_VALUE;
            long n2 = Integer.MAX_VALUE;
            if(p1 >= 0) n1 = (int) (a * Math.pow(nums[p1], 2) + b * nums[p1] + c);
            if(p2 <= nums.length - 1) n2 = (int) (a * Math.pow(nums[p2], 2) + b * nums[p2] + c);
            if(Math.abs(n1 - results[0]) < Math.abs(n2 - results[0])) {
                results[p ++] = (int) n1;
                p1 --;
            } else {
                results[p ++] = (int) n2;
                p2 ++;
            }
        }

        // Reverse array if necessary.
        if(a < 0) {
            int begin = 0;
            int end = results.length - 1;
            while(begin < end) {
                int temp = results[end];
                results[end --] = results[begin];
                results[begin ++] = temp;
            }
        }
        // Return.
        return results;
    }
   
    public static void main(String[] args) {
    		int[] arr = {-4, -2, 2, 4};
    		int a = 0;
    		int b = 3;
    		int c = 5;
    		System.out.println(Arrays.toString(sortTransformedArray(arr, a, b, c)));
    }
}
