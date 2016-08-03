package com.codingPractice.app.array;

public class FisrtMissingPositive {
	public int firstMissingPositive(int[] nums) {
        int p = 0;
		while(p<nums.length) {
			if(nums[p]!=p+1&&nums[p]>0&&nums[p]<nums.length&&nums[nums[p]-1]!=nums[p])
				swap(nums,p,nums[p]-1);
			else p++;
		}
		p = 0;
		while(p<nums.length&&nums[p]==p+1) p++;
		return p+1;
    }
	private void swap(int[] nums, int p, int q) {
		int temp = nums[p];
		nums[p] = nums[q];
		nums[q] = temp;
	}
}
