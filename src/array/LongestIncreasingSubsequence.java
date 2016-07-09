package array;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
	public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) return 0;
        int[] arr = new int[nums.length];
        Arrays.fill(arr, 1);
        for(int i=1; i<arr.length; ++i) {
            for(int j=0; j<i; ++j) {
                if(nums[i] >= nums[j]) 
                    arr[i] = Math.max(arr[i], arr[j]+1);
            }
        }
        int max = 0;
        for(int a:arr)
            if(a > max) max = a;
        return max;
    }
	
	public static void main(String[] args) {
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		int[] nums = {9,3,6,6,2,7};
		System.out.println(lis.lengthOfLIS(nums));
	}

	public int lengthOfLIS(int[] nums) {            
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }

        return len;
    }
}
