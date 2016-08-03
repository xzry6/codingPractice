package com.codingPractice.app.acmcoder;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class LinkString {
	public static void main(String[] args) {
//		Scanner s = new Scanner(System.in);
//		while(s.hasNextLine()) {
//			int count = s.nextInt();
//			Map<String, Integer> words = new HashMap<String, Integer>();
//			for(int i=0; i<count; ++i)
//				words.put(s.nextLine(), 2);
//			StringBuffer c = new StringBuffer(s.nextLine());
//			System.out.println(linkString(words, c, 1, true));
//		}
//		s.close();
		LinkString ls = new LinkString();
		Map<String, Integer> words = new HashMap<String, Integer>();
		words.put("abcde", 2);
		words.put("bcde", 2);
		words.put("ea", 2);
		System.out.println(ls.linkString(words, new StringBuffer("a"), 1, true));
		
	}
	
	public int linkString(Map<String, Integer> words, StringBuffer c, int length, boolean first) {
		int max = length;
		int l = c.length();
		if(!first) c.delete(0, 1);
		for(int i=0; i<l; ++i) {
			Iterator<String> it = words.keySet().iterator();
			while(it.hasNext()) {
				String s = it.next();
				int count = words.get(s);
				if(s.length() <= c.length()) continue;
				System.out.println(s.substring(0, c.length()));
				if(s.substring(0, c.length()).contentEquals(c)&&count>0) {
					words.put(s, count-1);
					max = Math.max(max, linkString(words, new StringBuffer(s), length+s.length()-c.length(), false));
					words.put(s, count);
				}
			}
			c.delete(0, 1);
		}
		return max;
	}
}
