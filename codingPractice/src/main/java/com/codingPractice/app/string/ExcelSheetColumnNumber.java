package com.codingPractice.app.string;

public class ExcelSheetColumnNumber {
	public static int titleToNumber(String s) {
		int length = s.length();
		if(length==0) return 0;
		int total = 0;
		for(int i=0; i<length; ++i) {
			char c = s.charAt(i);
			total += (c-64)*Math.pow(26,length-i-1);
		}
		return total;
    }
	public static void main(String[] args) {
		System.out.println(titleToNumber("AZ"));
	}
}
