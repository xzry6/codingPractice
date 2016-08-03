package com.codingPractice.app.number;

public class SqrtX {
	public static int sqrt(int x) {
		if(x<0) return -1;
		if(x==0) return 0;
		long start = 0;
		long end = x;
		while(start<end) {
			long mid = (start+end)/2;
			if(mid*mid>x) end = mid-1;
			else start = mid+1;
		}
		if(end*end>x) return (int)end-1;
		return (int)end;
    }
	public static void main(String[] args) {
		System.out.println(sqrt(999999999));
	}
}
