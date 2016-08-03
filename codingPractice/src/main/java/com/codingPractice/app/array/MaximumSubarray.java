package com.codingPractice.app.array;


public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
        if(nums.length==0) return 0;
        int max = nums[0];
        int temp = nums[0];
        for(int i=1; i<nums.length; ++i) {
        	temp = Math.max(temp+nums[i], nums[i]);
        	max = Math.max(temp, max);
        }
        return max;
    }
}
