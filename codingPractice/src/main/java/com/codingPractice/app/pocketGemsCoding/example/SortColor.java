package com.codingPractice.app.pocketGemsCoding.example;

import java.util.Arrays;

public class SortColor {
	public static void sortColors(int[] A) {
		if(A.length==0||A.length==1) return;
        int p0 = 0;
        int p1 = A.length-1;
		for(int i=0; i<A.length; ++i) {
			if(A[i]==0) {
				int temp = A[i];
				A[i] = A[p0];
				A[p0] = temp;
				p0++;
			}
			if(A[i]==2&&i<p1) {
				int temp = A[i];
				A[i] = A[p1];
				A[p1] = temp;
				p1--;
				i--;
			}
		}
    }
	public static void main(String[] args) {
		int[] a = {2,1,0,2,1,1,1,2,0,1,0,0,2,0,2,1,1,0,0,0,0,2,0,2,0,1,2,2};
		sortColors2(a);
		System.out.println(Arrays.toString(a));
	}
	
	public static void sortColors2(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) return;
        int begin = 0;
        int end = nums.length-1;
        begin = partition(nums, 0, begin, end);
        partition(nums, 1, begin, end);
    }
    
    private static int partition(int[] nums, int value, int begin, int end) {
        int p1 = begin;
        int p2 = end;
        while(p1 < p2) {
            if(nums[p1] == value) {
                p1++;
                continue;
            }
            if(nums[p2] != value) {
                p2--;
                continue;
            }
            int temp = nums[p1];
            nums[p1++] = nums[p2];
            nums[p2--] = temp;
        }
        if(nums[p2] != value) return p2;
        if(nums[p1] != value) return p1;
        return p1+1;
    }
}
