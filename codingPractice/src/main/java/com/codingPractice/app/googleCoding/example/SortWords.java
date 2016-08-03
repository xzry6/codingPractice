package com.codingPractice.app.googleCoding.example;

import java.util.Arrays;
import java.util.Comparator;

public class SortWords {
	public static void main(String[] args) {
		String[] arr1 = {"animal", "duck", "snake", "zebra", "horse", "mouse"};
		String[] arr2 = {"aab", "baa", "caa", "aaa", "aaaa"};
		sortWords(arr1);
		sortWords(arr2);
		for(String s:arr2) {
			System.out.println(s);
		}
	}

	public static String favLetters = "zh";

	// Have a comparator compare the words.
	private static Comparator<String> comparator = new Comparator<String>() {
		@Override
		public int compare(String s1, String s2) {
			return compareHelper(s1, s2, 0);
		}

		// Compare words in a recursive fashion.
		private int compareHelper(String s1, String s2, int index) {
			// Deal with out of bounds first.
			if(index == s1.length() && index == s2.length()) return 0;
			if(index == s1.length()) return -1;
			if(index == s2.length()) return 1;

			char c1 = s1.charAt(index);
			char c2 = s2.charAt(index);
			// When c1 == c2.
			if(c1 == c2) return compareHelper(s1, s2, index+1);

			int i1 = favLetters.indexOf(c1);
			int i2 = favLetters.indexOf(c2);
			// Return if one has the favorite char while the other doesn't.
			if(i1 != -1 && i2 == -1) return -1;
			if(i1 == -1 && i2 != -1) return 1;
			// When both have the chars.
			if(i1 != -1 && i2 != -1) return i1 - i2;
			// When both not have the chars.
			return s1.substring(index).compareTo(s2.substring(index));
			
		}
	};

	private static void sortWords(String[] arr) {
		// Deal with null and empty cases first.
		if(arr == null || arr.length == 0) return;
		// Sort array using designed comparator.
		Arrays.sort(arr, comparator);
	}
}
