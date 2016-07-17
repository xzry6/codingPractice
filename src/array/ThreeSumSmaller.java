package array;

import java.util.Arrays;

/**
 * Given an array of n integers nums and a target,
 * find the number of index triplets i, j, k with 0 <= i < j < k < n
 * that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 * 
 * For example, given nums = [-2, 0, 1, 3], and target = 2.
 * Return 2.
 * Because there are two triplets which sums are less than 2:
 * [-2, 0, 1]
 * [-2, 0, 3]
 * 
 * Follow up:
 * Could you solve it in O(n2) runtime?
 * 
 * @author Sean
 *
 */
public class ThreeSumSmaller {
	public static void main(String[] args) {
		ThreeSumSmaller tss = new ThreeSumSmaller();
		int[] nums = {3, -2, 0, 1};
		System.out.println(tss.threeSumSmaller(nums, 4));
	}

	public int threeSumSmaller(int[] nums, int target) {
        // Deal with empty and edge cases first.
        if(nums == null || nums.length == 0) return 0;
        // Sort.
        Arrays.sort(nums);
        // Three Pointers.
        int count = 0;
        for(int p1 = 0; p1 < nums.length - 2; ++ p1) {
        		int p2 = p1 + 1;
        		int p3 = nums.length - 1;
        		while(p2 < p3) {
        			int sum = nums[p1] + nums[p2] + nums[p3];
        			if(sum < target) {
        				count += p3 - p2;
        				p2 ++;
        			} else p3 --;
        		}
        }

        return count;
    }
}
