package com.codingPractice.app.number;

public class PowXN {
	public static double pow(double x, int n) {
		double pow = 1;
		do {
			if(n%2==1) pow*=x;
			if(n%2==-1) pow*=1/x;
			n = n/2;
			x *= x;
		} while(n!=0);
		return pow;
    }
	public static void main(String[] args) {
		System.out.println(pow(34.00515,-3));
		
		
	}
}
