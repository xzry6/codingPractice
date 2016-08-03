package com.codingPractice.app.pocketGemsCoding.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class StringGraph {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("gcd");
		list.add("jd");
		list.add("fcj");
//		list.add("ed");
		System.out.println(parseList(list));
	}

	public static String parseList(List<String> list) {
		// Deal with null and empty first.
		if(list == null || list.size() == 0) {
			return new String();
		}
		// Create a map.
		// Calculate the occurence.
		Map<Character, Set<Character>> map = new HashMap<Character, Set<Character>>();
		Map<Character, Integer> occurence = new HashMap<Character, Integer>();

		for(String string:list) {
			for(int i = 0; i < string.length() - 1; ++ i) {
				char c = string.charAt(i);
				char next = string.charAt(i + 1);
				if(map.containsKey(c)) {
					Set<Character> set = map.get(c);
					set.add(next);
				} else {
					Set<Character> set = new HashSet<Character>();
					set.add(next);
					map.put(c, set);
				}
				if(occurence.containsKey(next)) {
					occurence.put(next, occurence.get(next) + 1);
				} else {
					occurence.put(next, 1);
				}
			}
		}

		Set<Character> heads = new HashSet<Character>();
		for(String string:list) {
			for(int i = 0; i < string.length(); ++ i) {
				char c = string.charAt(i);
				if(!occurence.containsKey(c)) {
					heads.add(c);
				}
			}
		}
		
		// Build the string.
		Queue<Character> queue = new LinkedList<Character>();
		StringBuilder sb = new StringBuilder();
		for(Character c:heads) {
			queue.offer(c);
		}
		while(!queue.isEmpty()) {
			Character c = queue.poll();
			sb.append(c);
			if(map.containsKey(c)) {
				for(Character neighbor:map.get(c)) {
					occurence.put(neighbor, occurence.get(neighbor) - 1);
					if(occurence.get(neighbor) == 0) {
						queue.offer(neighbor);
					}
				}
			}
		}
		// Return.
		return sb.toString();
	}
}
