package com.codingPractice.app.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class WordLadder {
	public static int ladderLength(String start, String end, Set<String> dict) {
		if(dict.isEmpty()&&!start.equals(end)) return 0;
		if(start.equals(end)) return 1;
		List<String> list = new ArrayList<String>();
		Stack<String> stack = new Stack<String>();
		list.add(start);
		int count = 1;
		int depth = 1;
		
		while(!dict.isEmpty()&&!list.isEmpty()) {
			while(!stack.isEmpty()) {
				String rm = stack.pop();
				dict.remove(rm);
			}
			if(count==0) {
				depth++;
				count = list.size();
			}
			String temp = list.remove(0);
			if(compare(temp,end)) return depth+1;
			count--;
			Iterator<String> it = dict.iterator();
			while(it.hasNext()) {
				String s = it.next();
				if(compare(temp,s)) {
					stack.add(s);
					list.add(s);
				}
			}
		}
		return 0;
    }
	static boolean compare(String start, String end) {
		int count = 0;
		for(int i=0; i<start.length(); ++i) {
			if(start.charAt(i)!=end.charAt(i)) count++;
		}
		if(count==1) return true;
		return false;
	}
	
	public static int ladderLength0(String start, String end, Set<String> dict) {
		if(dict.isEmpty()&&!start.equals(end)) return 0;
		if(start.equals(end)) return 1;
		List<String> list = new ArrayList<String>();
		list.add(start);
		int count = 1;
		int depth = 1;
		
		while(!list.isEmpty()) {
			if(count==0) {
				depth++;
				count = list.size();
			}
			String original = list.remove(0);
			count--;
			for(int i=0; i<original.length(); ++i) {
				char c = original.charAt(i);
				for(char t='a'; t<='z'; ++t) {
					if(t==c) continue;
					String temp = original.substring(0, i)+t+original.substring(i+1);
					if(temp.equals(end)) return depth+1;
					if(dict.contains(temp)) {
						list.add(temp);
						dict.remove(temp);
					}
				}
			}
		}
		return 0;
		
	}
	
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("hot");
		set.add("dot");
		set.add("dog");
		set.add("lot");
		set.add("log");
		//System.out.println(ladderLength("hit","cog",set));
		System.out.println(ladderLength0("hit","cog",set));
	}
}
