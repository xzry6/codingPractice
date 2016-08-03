package com.codingPractice.app.googleCoding.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class StringDecompression {
	public static void main(String[] args) {
		String s = "a3[2[de]f]";
		System.out.println(decompress2(s));
	}

	/*
	 * - digit: add with previous digit.
	 * - letter: multiply with previous digit.
	 * - brackets: begin recursion.
	 */
	private static String decompress(String s) {
		// Deal with null and empty first.
		if(s == null || s.length() == 0) return new String();
		// Use a stack storing brackets.
		Stack<String[]> stack = new Stack<String[]>();

		String preS = new String();
		String multiplier = new String();
		for(int i=0; i<s.length(); ++i) {
			char c = s.charAt(i);
			if(c == ']') {
				String[] sa = stack.pop();
				String temp = new String();
				for(int m=0; m<Integer.parseInt(sa[1]); ++m)
					temp += preS;
				preS = sa[0] + temp;
			}
			else if(c == '[') {
				String[] sa = {preS, multiplier};
				stack.add(sa);
				preS = new String();
				multiplier = new String();
			}
			else if(Character.isDigit(c)) {
				multiplier += c;
			}
			else if(Character.isLetter(c)) {
				if(multiplier.length() > 0) {
					String temp = new String();
					for(int m=0; m<Integer.parseInt(multiplier); ++m)
						temp += c;
					preS += temp;
					multiplier = new String();
				}
				else preS += c;
			}
		}
		return preS;
	}

	private static int index = 0;

	private static String decompress2(String s) {
		// Deal with null and empty first.
		if(s == null || s.length() == 0) return new String();
		return recursive(s, 1);
	}
	
	private static String recursive(String s, int multiplier) {
		int localMultiplier = 0;
		String localString = new String();
		while(index < s.length()) {
			char c = s.charAt(index++);
			if(c == '[') {
				localString += localMultiplier == 0
						     ? recursive(s, 1)
						     : recursive(s, localMultiplier);
				localMultiplier = 0;
			}
			else if(c == ']') break;
			else if(Character.isDigit(c))
				localMultiplier = localMultiplier*10+Character.getNumericValue(c);
			else if(Character.isLetter(c)) {
				if(localMultiplier == 0) {
					localString += c;
					continue;
				}
				String temp = new String();
				for(int m=0; m<localMultiplier; ++m) {
					temp += c;
					localMultiplier = 0;
				}
				localString += temp;
			}
		}
		String result = new String();
		for(int m=0; m<multiplier; ++m)
			result += localString;
		return result;
	}
}
