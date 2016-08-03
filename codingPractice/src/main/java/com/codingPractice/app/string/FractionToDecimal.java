package com.codingPractice.app.string;

import java.util.HashMap;

public class FractionToDecimal {
	public static String fractionToDecimal(int numerator, int denominator) {
		HashMap<Long, Integer> hash = new HashMap<Long, Integer>();
		long num = numerator;
		String s = new String();
		if(denominator==0) return s;
		long a = num/denominator;
		long b = num%denominator;
		hash.put(b, s.length());
		while(b!=0) {
			long temp = b*10;
			s += Math.abs(temp/denominator);
			b = temp%denominator;
			if(hash.containsKey(b)) {
				int position = hash.get(b);
				s = s.substring(0,position)+"("+s.substring(position)+")";
				break;
			}
			else {
				hash.put(b, s.length());
			}
		}
		String ss = Long.toString(a);
		if(numerator>0&&denominator<0) ss = "-"+ss;
		if(s.length()==0) return ss;
		return ss+"."+s;
    }
	public static void main(String[] args) {
		System.out.println(fractionToDecimal(1,90));
	}
}
