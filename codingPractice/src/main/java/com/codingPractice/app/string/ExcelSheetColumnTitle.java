package com.codingPractice.app.string;

public class ExcelSheetColumnTitle {
	public static String convertToTitle(int n) {
		String s = new String();
		if(n<=0) return s;
		while(n!=0) {
			int c = (n-1)%26+65;
			s = (char)c+s;
			n = (n-1)/26;
		}
		return s;
	}
	public static void main(String[] args) {
		System.out.println(convertToTitle(1000));
	}
}
