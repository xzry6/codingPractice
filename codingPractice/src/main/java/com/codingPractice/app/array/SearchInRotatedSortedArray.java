package com.codingPractice.app.array;

public class SearchInRotatedSortedArray {
	public int search(int[] nums, int target) {
        if(nums == null) return -1;
        int start = 0;
        int end = nums.length-1;
        while(start+1 < end) {
        		int mid = start+(end-start)/2;
        		if(nums[mid] == target) return mid;
        		if(nums[mid] < nums[start]) {
        			if(target >= nums[mid] && target <= nums[end]) 
        				start = mid;
        			else end = mid;
        		} else {
        			if(target <= nums[mid] && target >= nums[start])
        				end = mid;
        			else start = mid;
        		}
        }
        if(nums[start] == target) return start;
        if(nums[end] == target) return end;
        return -1;
    }
}
