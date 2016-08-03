package com.codingPractice.app.array;

public class TotalOccurance {
	public int totalOccurrence(int[] A, int target) {
        // Write your code here
        if(A == null || A.length == 0) return 0;
        int start = 0;
        int end = A.length-1;
        while(start+1 < end) {
            if(A[start] == target && A[end] == target) break;
            int mid = start+(end-start)/2;
            if(A[mid] == target) {
                if(A[start] == target) {
                    while(mid < A.length-1 && A[mid] == A[mid+1])
                        mid++;
                    end = mid;
                } else {
                    while(mid > 0 && A[mid] == A[mid-1])
                        mid--;
                    start = mid;
                }
                
            }
            else if(A[mid] > target) end = mid;
            else start = mid;
        }
        if(A[start] == target && A[end] == target)
        		return end-start+1;
        if(A[start] != target && A[end] != target)
        		return 0;
        return end-start;
    }
	
	public static void main(String[] args) {
		TotalOccurance to = new TotalOccurance();
		int[] a = {1,3,3,4,5};
		System.out.println(to.totalOccurrence(a, 6));
	}
}
