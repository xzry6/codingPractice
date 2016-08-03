package com.codingPractice.app.array;

public class SearchInRotatedSortedArrayII {
	public boolean search(int[] nums, int target) {
        if(nums == null) return false;
        for(int n:nums) 
        		if(n == target) return true;
        return false;
    }
}
