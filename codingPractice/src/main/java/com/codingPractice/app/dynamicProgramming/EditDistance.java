package com.codingPractice.app.dynamicProgramming;

public class EditDistance {
	public int minDistance(String word1, String word2) {
		int w1 = word1.length();
		int w2 = word2.length();
		int[] table = new int[w2+1];
		for(int j=1; j<=w2; ++j) table[j] = j;
		for(int i=0; i<w1; ++i) {
			int pre = i;
			table[0] = i+1;
			for(int j=1; j<=w2; ++j) {
				int cur = table[j];
				if(word1.charAt(i)==word2.charAt(j-1)) table[j] = pre;
				else table[j] = Math.min(Math.min(table[j], table[j-1]),pre)+1;
				pre = cur;
			}
		}
		return table[w2];
    }
}
