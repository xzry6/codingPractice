package array;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an array nums,
 * there is a sliding window of size k which is moving
 * from the very left of the array to the very right.
 * You can only see the k numbers in the window.
 * Each time the sliding window moves right by one position.
 * 
 * For example,
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

	Window position                Max
	---------------               -----
	[1  3  -1] -3  5  3  6  7       3
	 1 [3  -1  -3] 5  3  6  7       3
	 1  3 [-1  -3  5] 3  6  7       5
	 1  3  -1 [-3  5  3] 6  7       5
	 1  3  -1  -3 [5  3  6] 7       6
	 1  3  -1  -3  5 [3  6  7]      7

 * Therefore, return the max sliding window as [3,3,5,5,6,7].
 * 
 * Note: 
 * You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
 * 
 * Follow up:
 * Could you solve it in linear time?
 * 
 * @author Sean
 *
 */
public class SlidingWindowMaximum {
	// Comparator.
    private Comparator<Integer> comparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer i1, Integer i2) {
            return i2.intValue() - i1.intValue();
        }        
    };

    public int[] maxSlidingWindow(int[] nums, int k) {
    		if(nums == null || nums.length == 0) return nums;

        int[] arr = new int[nums.length - k + 1];
        Queue<Integer> queue = new PriorityQueue<Integer>(comparator);

        for(int i = 0; i < nums.length; ++ i) {
            if(queue.size() == k) queue.remove(nums[i - k]);
            queue.add(nums[i]);
            if(queue.size() == k) arr[i - k + 1] = queue.peek();
        }

        return arr;
    }
}
