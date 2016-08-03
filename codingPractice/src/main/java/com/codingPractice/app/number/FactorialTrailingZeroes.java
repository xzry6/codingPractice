package com.codingPractice.app.number;

public class FactorialTrailingZeroes {
	public int trailingZeroes(int n) {
		int count = 0;
        while(n/5!=0) {
        	n = n/5;
        	count += n;
        }
        return count;
    }
}
