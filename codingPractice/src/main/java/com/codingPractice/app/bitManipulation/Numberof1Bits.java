package com.codingPractice.app.bitManipulation;

public class Numberof1Bits {
	public static int hammingWeight(int n) {
        if(n==0) return 0;
        int count = 0;
        while(n!=0) {
        	if((n&1)==1) count++;
        	n>>>=1;
        }
        return count;
    }
}
