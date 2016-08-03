package com.codingPractice.app.number;

import java.util.Arrays;

public class SingleNumber {
	public int singleNumber(int[] A) {
		if(A.length==0) return -1;
		if(A.length==1) return A[0];
        Arrays.sort(A);
        boolean flag = true;
        for(int i=0; i<A.length-1; ++i){
        	if(A[i]!=A[i+1]&&flag) return A[i];
        	if(A[i]!=A[i+1]) flag = true;
        	else flag = false;
        }
        return A[A.length-1];
    }
	public static void main(String[] args) {
		System.out.println(0^2);
		int s = 1;
		System.out.println(s|=s<<2);
	}
}
