package com.codingPractice.app.googleSample;

public class RealCodingSample {
	public static int solution(int[] A) {
        // write your code in Java SE 8
        int equilibrium = -1;
		if(A == null || A.length == 0) {
	        	return equilibrium;
	    }
        int length = A.length;
        int[] forwardSum = new int[length];
        int[] backwardSum = new int[length];
        forwardSum[0] = A[0];
        backwardSum[length-1] = A[length-1];
        for(int i=1; i<length; ++i) {
            forwardSum[i] = forwardSum[i-1]+A[i];
            backwardSum[length-i-1] = backwardSum[length-i]+A[length-i-1];
        }
        
        for(int i=1; i<length-1; ++i) {
            if(forwardSum[i-1] == backwardSum[i+1]) {
                equilibrium = i;
                break;
            }
        }
        return equilibrium;
    }
	
	public static void main(String[] args) {
		int[] A = new int[2];
		A[0] = -1;
		A[1] = -1;
//		A[0] = -1;
//		A[1] =  3;
//		A[2] = -1;
//		A[3] =  2;
		System.out.println(RealCodingSample.solution(A));
		System.out.println(Integer.MAX_VALUE);
		int i = 1000000000;
		System.out.println(i);
	}
}
