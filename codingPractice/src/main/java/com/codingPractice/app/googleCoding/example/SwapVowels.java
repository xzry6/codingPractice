package com.codingPractice.app.googleCoding.example;

import java.util.HashSet;
import java.util.Set;

public class SwapVowels {

	private static String vowels = "aeiouAEIOU";

	public static void main(String[] args) {
		String s = "I love goole!";
		System.out.println(swap(s));
		Set<String> set = new HashSet<String>();
		set.add("a google interview");
		set.add("a google interview");
		for(String string:set)
			System.out.println(string);
	}

	private static String swap(String s) {
		char[] charr = s.toCharArray();
		// Deal with null and empty string first.
		if(s == null || s.length() == 0) return String.valueOf(charr);
		// Have two pointers.
		int begin = 0;
		int end = s.length()-1;
		// Traverse the string.
		while(begin < end) {
			if(vowels.indexOf(charr[begin]) == -1) {
				begin ++;
				continue;
			}
			if(vowels.indexOf(charr[end]) == -1) {
				end --;
				continue;
			}
			char temp = charr[begin];
			charr[begin++] = charr[end];
			charr[end--] = temp;
		}
		// Return.
		return String.valueOf(charr);
	}
}
