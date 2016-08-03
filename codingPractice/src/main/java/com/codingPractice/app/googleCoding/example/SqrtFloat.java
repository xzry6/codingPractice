package com.codingPractice.app.googleCoding.example;

public class SqrtFloat {
	public static void main(String[] args) {
		double x = 4;
		double p = 2.0;
		int k = 2;
		System.out.println(sqrt(x, p, k));
	}

	private static boolean sqrt(double x, double p, int k) {
		if(p > x) return false;
		if(k > Double.toString(p).length()) return false;

		double begin = 0;
		double end = x;
		while(begin + Math.pow(10, 1-k) < end) {
			double mid = (begin + end) / 2;
			if(mid * mid >= x) end = mid;
			else begin = mid;
		}
		double finded = end;
		if(end * end > x) finded = begin;

		String pS = Double.toString(p);
		String fS = Double.toString(finded);
		if(fS.length() < k) return false;
		for(int i=0; i<k; ++i) {
			char pc = pS.charAt(i);
			char fc = fS.charAt(i);
			if(pc != fc) return false;
			if(pc == '.') {
				k ++;
				continue;
			}
		}
		return true;
	}
}
