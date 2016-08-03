package com.codingPractice.app.array;

import java.util.Arrays;

public class MergeSortedArray {
	public static void merge(int A[], int m, int B[], int n) {
		int a = m-1;
	       int b = n-1;
	       int k = m+n-1;
	       while(a>=0&&b>=0) {
	           if(A[a]>B[b]) {
	               A[k] = A[a];
	               a--;
	           } else {
	               A[k] = B[b];
	               b--;
	           }
	           k--;
	       }
	       while(b>=0) A[k--] = B[b--];
    }
	
	static void merge(int a) {
		System.out.println(a);
		
		
	}
	public static void main(String[] args) {
		int[] A = {1,0};
		int[] B = {2};
		Arrays.sort(B);
		merge(A,1,B,B.length);
		System.out.println(Arrays.toString(A));
		merge(10);
		
		
	}
}
