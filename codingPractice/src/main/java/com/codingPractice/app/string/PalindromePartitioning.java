package com.codingPractice.app.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePartitioning {
	static List<List<String>> list;
	static boolean[] bool;
	public static List<List<String>> partition(String s) {
        list = new ArrayList<List<String>>();
		if(s.length()==0) return list;
        bool = new boolean[s.length()+1];
        Arrays.fill(bool, true);
        List<String> instance = new ArrayList<String>();
        recursive(instance, s);
        return list;
    }
	private static void recursive(List<String> instance, String s) {
		if(s.length()==0) {
			list.add(instance);
			return;
		}
		for(int i=1; i<=s.length(); ++i) {
			if(judge(s.substring(0, i))&&bool[i]) {
				List<String> temp = new ArrayList<String>();
				for(int x=0; x<instance.size(); ++x) {
					temp.add(instance.get(x));
				}
				temp.add(s.substring(0, i));
				int l = list.size();
				recursive(temp,s.substring(i, s.length()));
				if(temp.size()==instance.size()+1&&l==list.size()) bool[i] = false;
			}
		}
	}
	private static boolean judge(String s) {
		int start = 0;
		int end = s.length()-1;
		while(start<=end) {
			if(s.charAt(start)!=s.charAt(end)) return false;
			start++;
			end--;
		}
		return true;
	}
	public static void main(String[] args) {
		String s = "ababababababababababababcbabababababababababababa";
		List<List<String>> aa = new ArrayList<List<String>>();
		aa = partition(s);
		for(int i=0; i<aa.size(); ++i) {
			List<String> ss = aa.get(i);
			for(int j=0; j<ss.size(); ++j) {
				System.out.print(ss.get(j)+" ");
			}
			System.out.println("");
		}
		//System.out.println(judge("abcba"));
	}
}
