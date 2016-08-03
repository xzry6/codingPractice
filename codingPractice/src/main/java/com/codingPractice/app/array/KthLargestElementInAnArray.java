package com.codingPractice.app.array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
	public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int size = 0;
        for(int n:nums) {
        	pq.offer(n);
        	size++;
        	if(size>k) pq.poll();        	
        }
        return pq.peek();
    }
	Comparator<Integer> c = new Comparator<Integer>() {
        public int compare(Integer i1, Integer i2) {
            if(i1.equals(i2)) return 0;
            if(i1.intValue() < i2.intValue()) return 1;
            else return -1;
        }
    };
	public int kthLargestElement(int k, int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) return -1;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, c);
        for(int n:nums) {
            if(queue.size() < k || n < queue.peek()) {
                queue.add(n);
                if(queue.size() > k) queue.poll();
            }
        }
        return queue.poll();
    }
	
	public int findKthLargest2(int[] nums, int k) {
		int start = 0;
		int end = nums.length-1;
		while(start<end) {
			int t = nums.length-partition(nums,start,end);
			if(t==k) break;
			if(t>k) start = nums.length-t+1;
			if(t<k) end = nums.length-t-1;
		}
		return nums[nums.length-k];
	}
	
	private int partition(int[] nums, int start, int end) {
		int i = start, j = start;
		while(j<end) {
			if(nums[j]<nums[end])
				swap(nums,i++,j);
			j++;
		}
		swap(nums,i,end);
		return i;
	}
	
	private void swap(int[] nums, int p1, int p2) {
		int temp = nums[p1];
		nums[p1] = nums[p2];
		nums[p2] = temp;
	}
	
	public static void main(String[] args) {
		int[] array = {2,1,7,8,3,4,5};
		KthLargestElementInAnArray kleiaa = new KthLargestElementInAnArray();
		System.out.println(kleiaa.kthLargestElement(1, array));
	}
}
