package com.codingPractice.app.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an unsorted array nums,
 * reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 * 
 * Example:
 * (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6]. 
 * (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
 * 
 * Note:
 * You may assume all input has valid answer.
 * 
 * Follow Up:
 * Can you do it in O(n) time and/or in-place with O(1) extra space?
 * 
 * @author Sean
 *
 */
public class WiggleSortII {
	public static void main(String[] args) {
		int[] nums = {3, 2, 1, 4, 5, 5, 5, 5};
		wiggleSort(nums);
		System.out.println(Arrays.toString(nums));
	}

	public static void wiggleSort(int[] nums) {
        if(nums == null || nums.length == 0) return;

        Queue<Integer> queue = new PriorityQueue<Integer>();
        for(int num:nums) queue.offer(num);
        List<Integer> list = new ArrayList<Integer>();
        while(!queue.isEmpty()) list.add(queue.poll());

        int mid = list.size() / 2;
        int begin = mid;
        int end = mid;
        while(begin > 0 && list.get(begin - 1) == list.get(begin)) begin --;
        while(end < nums.length - 1 && list.get(end + 1) == list.get(end)) end ++;

        int p = nums.length - 1;
        Arrays.fill(nums, -1);
        for(int i = 1; i < nums.length; i += 2) {
        		if(p > end) nums[i] = list.get(p --);
        		else break;
        }
        p = 0;
        for(int i = nums.length % 2 == 0 ? nums.length - 2 : nums.length - 1; i >= 0; i -= 2) {
        		if(p < begin) nums[i] = list.get(p ++);
        		else break;
        }
        for(int i = 0; i < nums.length; ++ i) {
        		if(nums[i] == -1) nums[i] = list.get(mid);
        }
    }
}
