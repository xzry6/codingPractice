package com.codingPractice.app.array;

public class FindMinimumInRotatedSortedArray {
	public static int findMin(int[] num) {
        if(num.length==0) return 0;
        return recursive(0,num.length-1,num);
    }
	public static int recursive(int start, int end, int[] num) {
		while(start!=end) {
			int mid = (start+end)/2;
			if(num[mid]>num[end]) 
				start = mid+1;
        	else if(num[mid]<num[end]) 
        		end = mid;
        	else if(recursive(mid+1,end,num)<recursive(start,mid,num))
        		start = mid+1;
        	else end = mid;
		}
		return num[start];
	}
	public static void main(String[] args) {
		int[] a = {3,3,1,3};
		System.out.println(findMin(a));
	}
}
