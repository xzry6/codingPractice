package com.codingPractice.app.array;

public class MaximumProductSubarray {
	public static int maxProduct(int[] A) {
        if(A.length==0) return -1;
		int maxlocal = A[0];
		int minlocal = A[0];
		int maxglobal = A[0];
		for(int i=0; i<A.length; ++i) {
			int temp = maxlocal;
			maxlocal = Math.max(maxlocal*A[i], A[i]);
			maxlocal = Math.max(maxlocal, minlocal*A[i]);
			minlocal = Math.min(minlocal*A[i], A[i]);
			minlocal = Math.min(minlocal, temp*A[i]);
			maxglobal = Math.max(maxlocal, maxglobal);
		}
		return maxglobal;
    }
	public static int maxProduct2(int[] nums) {
        if(nums == null || nums.length ==0)
            return -1;
        int product = nums[0];
        int max = nums[0];
        int negmax = nums[0] < 0 ? nums[0]:Integer.MIN_VALUE;
        for(int i=1; i<nums.length; ++i) {
            if(product == 0) {
                product = nums[i];
                negmax = nums[i] < 0 ? nums[i]:Integer.MIN_VALUE;
                max = Math.max(max, nums[i]);
                continue;
            }
            product *= nums[i];
            max = Math.max(max, product);
            if(product < 0) {
                max = Math.max(max, product/negmax);
                negmax = Math.max(negmax, product);
            }
        }
        return max;
    }
	public static void main(String[] args) {
		int[] A = {1,2,3,-4};
		int[] arr = {1,0,-1,2,3,-5,-2};
		System.out.println(maxProduct(A));
		System.out.println(maxProduct2(arr));
	}
}
