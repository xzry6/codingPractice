package com.codingPractice.app.pocketGemsCoding.example;

/**
 * Give four button,
 * '1' - print a 'A';
 * '2' - select all text;
 * '3' - copy text;
 * '4' - paste text;
 * 
 * You are give N options, how 
 * many 'A' can you print at most?
 * 
 * This problem could be found via
 * http://www.1point3acres.com/bbs/thread-157984-1-1.html
 * http://www.geeksforgeeks.org/how-to-print-maximum-number-of-a-using-given-four-keys/
 * @author Sean
 */
public class Keyboard {
	private int maxValue(int N) {
		// Deal with edge cases.
		if(N < 0) return -1;
		if(N <= 6) return N;
		// Have a initial array ready for dp.
		int[] array = new int[N];
		for(int i=0; i<6; ++i) array[i] = i;
		// Have an iteration on the array.
		for(int i=6; i<N; ++i) {
			int max = 0;
			for(int j=0; j<i-2; ++j) {
				int temp = array[i]*(i-j-1);
				max = Math.max(max, temp);
			}
			array[i] = max;
		}
		// Return value.
		return array[array.length-1];
	}
}
