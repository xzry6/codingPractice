package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * You are given an integer array nums and
 * you have to return a new counts array.
 * 
 * The counts array has the property where
 * counts[i] is the number of smaller elements
 * to the right of nums[i].
 * 
 * Example:
 * Given nums = [5, 2, 6, 1]
 * 
 * 1. To the right of 5 there are 2 smaller elements (2 and 1).
 * 2. To the right of 2 there is only 1 smaller element (1).
 * 3. To the right of 6 there is 1 smaller element (1).
 * 4. To the right of 1 there is 0 smaller element.
 * 
 * Return the array [2, 1, 1, 0].
 * 
 * 
 * @author Sean
 *
 */
public class CountOfSmallerNumbersAfterSelf {
	public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) return list;

        List<Integer> sorted = new ArrayList<Integer>();
        for(int i = nums.length - 1; i >= 0; -- i) {
        		int index = findNumber(sorted, nums[i]);
        		sorted.add(index, nums[i]);
        		list.add(0, index);
        }

        return list;
    }

	private int findNumber(List<Integer> list, int number) {
		if(list == null || list.size() == 0) return 0;

		int begin = 0;
		int end = list.size() - 1;
		while(begin + 1 < end) {
			int mid = (begin + end) / 2;
			if(list.get(mid) >= number) end = mid;
			else begin = mid;
		}

		if(list.get(end) < number) return end + 1;
		if(list.get(begin) < number) return begin + 1;
		return begin;
	}

	public static void main(String[] args) {
		CountOfSmallerNumbersAfterSelf c = new CountOfSmallerNumbersAfterSelf();
		int[] arr = {5, 2, 6, 1};
		List<Integer> list = c.countSmaller(arr);
		for(int i:list) System.out.println(i);
	}
}
