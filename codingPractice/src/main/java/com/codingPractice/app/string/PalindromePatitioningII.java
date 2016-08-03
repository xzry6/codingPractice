package com.codingPractice.app.string;

import java.util.Arrays;

public class PalindromePatitioningII {
	static int[] min;
	public static int minCut(String s) {
        if(s.length()<2) return 0;
        min = new int[s.length()+1];
        Arrays.fill(min, -1);
        recursive(s,0);
        return min[0]-1;
    }
	
	
	static void recursive(String s, int pos) {
		if(pos==min.length-1) {
			min[pos] = 0;
			return;
		}
		int temp = Integer.MAX_VALUE;
		for(int i=0; i<s.length(); ++i) {
			if(judge(s.substring(0, i+1))) {
				if(min[pos+i+1]==Integer.MAX_VALUE) continue;
				if(min[pos+i+1]==-1)
					recursive(s.substring(i+1), pos+i+1);
				temp = Math.min(temp, min[pos+i+1]+1);
			}
			else continue;
		}
		min[pos] = temp;
	}
	
	
	static boolean judge(String s) {
		int begin = 0;
		int end = s.length()-1;
		do {
			char b = s.charAt(begin);
			char e = s.charAt(end);
			if(b!=e) return false;
			begin++;
			end--;
		} while(begin<=end);
		return true;
	}
	public static void main(String[] args) {
		String s = "abbab"; 
		System.out.println(minCut(s));
		System.out.println(minCut2(s));
	}
	public static int minCut2(String s) {
		if(s.length()<2) return 0;
		int[] min = new int [s.length()+1];
		boolean[][] bool = new boolean[s.length()][s.length()];
		for(int i=0; i<min.length; ++i) {
			min[i] = s.length()-i;
		}
		for(int i=s.length()-1; i>=0; --i) {
			for(int j=i; j<s.length(); ++j) {
				if(s.charAt(i)==s.charAt(j)&&(j-i<2||bool[i+1][j-1])) {
					bool[i][j] = true;
					min[i] = Math.min(min[i], min[j+1]+1);
				}
			}
		}
		return min[0]-1;
	}
	
//	
//	public static int minCut3(String s) {
//		StringBuffer sb = new StringBuffer(s);
//	}
}
