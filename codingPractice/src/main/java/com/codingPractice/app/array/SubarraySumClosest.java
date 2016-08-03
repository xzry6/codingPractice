package com.codingPractice.app.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class SubarraySumClosest {
	public static ArrayList<Integer> subarraySumClosest(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) return null;
        Comparator<StructuredArray> c = new Comparator<StructuredArray>() {
            public int compare(StructuredArray a, StructuredArray b) {
                if(a.sum < b.sum) return -1;
                if(a.sum > b.sum) return 1;
                return 0;
            }
        };
        ArrayList<Integer> list = new ArrayList<Integer>();
        StructuredArray[] arr = new StructuredArray[nums.length+1];
        arr[0] = new StructuredArray(0, 0);
        for(int i=1; i<arr.length; ++i) 
            arr[i] = new StructuredArray(arr[i-1].sum+nums[i-1], i);
        Arrays.sort(arr, c);
        int min = Integer.MAX_VALUE;
        StructuredArray s1 = arr[0];
        StructuredArray s2 = arr[0];
        for(int i=1; i<arr.length; ++i) {
        		int temp = Math.abs(arr[i].sum-arr[i-1].sum);
        		if(temp < min) {
        			min = temp;
        			s1 = arr[i];
        			s2 = arr[i-1];
        		}
        }
        
        list.add(Math.min(s1.index, s2.index));
        list.add(Math.max(s1.index, s2.index)-1);
        return list;
    }
	
	public static void main(String[] args) {
		int[] a = {-10,-2,-3,-100,1,2,3,-1,4};
		ArrayList<Integer> list = subarraySumClosest(a);
		for(int l:list) 
			System.out.println(l);
	}
}

class StructuredArray {
    int sum;
    int index;
    public StructuredArray(int sum, int index) {
        this.sum = sum;
        this.index = index;
    }
}
