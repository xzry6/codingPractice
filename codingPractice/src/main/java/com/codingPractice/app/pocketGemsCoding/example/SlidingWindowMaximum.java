package com.codingPractice.app.pocketGemsCoding.example;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class SlidingWindowMaximum {
	 // Have a comparator.
    public Comparator<int[]> comparator = new Comparator<int[]>() {
        @Override
        public int compare(int[] a1, int[] a2) {
            return a2[0] - a1[0];
        }
    };

    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        // Create a new arraylist.
        ArrayList<Integer> list = new ArrayList<Integer>();
        // Deal with edge cases first.
        if(nums == null || nums.length < k) return list;
        // Have a priority queue.
        Queue<int[]> queue = new PriorityQueue<int[]>(comparator);
        // And a map.
        Map<Integer, int[]> map = new HashMap<Integer, int[]>();

        // Initialize variables.
        for(int i=0; i<k; ++i) {
            int[] arr = {nums[i], i};
            queue.offer(arr);
            map.put(i, arr);
        }
        list.add(queue.peek()[0]);

        // Iterate through the old array.
        for(int i=k; i<nums.length; ++i) {
            // Delete the number out of the window first.
            int[] oldArr = map.remove(i-k);
            queue.remove(oldArr);
            // Add new number.
            int[] newArr = {nums[i], i};
            queue.offer(newArr);
            map.put(i, newArr);
            // Get the maximum number.
            list.add(queue.peek()[0]);
        }
        // Return new arraylist.
        return list;
    }

    public static void main(String[] args) {
    		SlidingWindowMaximum swm = new SlidingWindowMaximum();
    		int[] arr = {1 ,2 ,7, 7, 2};
    		int k = 1;
    		ArrayList<Integer> list = swm.maxSlidingWindow2(arr, k);
    		for(int num:list) {
    			System.out.println(num);
    		}
    }

    public ArrayList<Integer> maxSlidingWindow2(int[] nums, int k) {
        // Create an array list.
        ArrayList<Integer> list = new ArrayList<Integer>();
        // Deal with edge cases first.
        if(nums == null || nums.length == 0 || k == 0) {
            return list;
        }

        // Have a Deque.
        Deque<Integer> deque = new ArrayDeque<Integer>();

        for(int i = 0; i < nums.length; ++ i) {
            int num = nums[i];
            while(!deque.isEmpty() && deque.peekLast() < num) {
                deque.pollLast();
            }
            deque.addLast(num);
            if(i >= k) {
                if(!deque.isEmpty() && deque.peekFirst() == nums[i - k]) {
                    deque.pollFirst();
                }
            }
            if(i >= k - 1) {
            		list.add(deque.peekFirst());
            }
        }
        
        // Return.
        return list;
    }
}
