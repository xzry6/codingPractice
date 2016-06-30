package array;

import java.util.Arrays;

public class RotateArray {
	public static void rotate(int[] nums, int k) {
		int n = nums.length;
		for(int i=0; i<k; ++i) {
			int temp = nums[n-1];
			System.arraycopy(nums, 0, nums, 1, n-1);
			nums[0] = temp;
		}
    }
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7};
 		rotate(a,8);
 		System.out.println(Arrays.toString(a));
	}
}
