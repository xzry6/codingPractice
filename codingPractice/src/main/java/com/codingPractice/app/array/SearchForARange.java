package com.codingPractice.app.array;

import java.util.Arrays;

public class SearchForARange {
	public int[] searchRange(int[] nums, int target) {
        if(nums == null) return null;
        int[] result = {-1,-1};
        
        int start = 0;
        int end = nums.length-1;
        while(start+1 < end) {
        		int mid = start+(end-start)/2;
        		if(nums[mid] >= target) end = mid;
        		else start = end;
        }
        if(nums[start] == target) Arrays.fill(result, start);
        else if(nums[end] == target) Arrays.fill(result, end);
        
        start = 0;
        end = nums.length-1;
        while(start+1 < end) {
        		int mid = start+(end-start)/2;
        		if(nums[mid] <= target) start = mid;
        		else end = mid;
        }
        if(nums[end] == target) {
        		result[1] = end;
        		if(result[0] == -1) result[0] = end;
        }
        if(nums[start] == target) {
        		result[1] = start;
        		if(result[0] == -1) result[0] = start;
        }
        	return result;
    }
}
