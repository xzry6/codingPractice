package com.codingPractice.app.acmcoder;

import java.util.HashMap;
import java.util.Map;

public class IsPermutation {
	public static void main(String[] args) {
		String a = "abcd";
		String b = "adbc";
		System.out.println(isPermutation(a, b));
	}
	static boolean isPermutation(String a, String b) {
        // Deal with empty and null first.
        if(a == null && b == null) return true;
        if(a == null || b == null) return false;
        if(a.length() == 0 && b.length() == 0) return true;
        if(a.length() == 0 || b.length() == 0) return false;
        if(a.length() != b.length()) return false;
        // Have a map storing characters.
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        // First loop storing string a.
        addFirstStringToMap(a, map);
        // Check on the second loop.
        if(!checkSecondString(b, map)) return false;
        // Return.
        return map.size() == 0;
    }

    static void addFirstStringToMap(String a, Map<Character, Integer> map) {
        for(int i=0; i<a.length(); ++i) {
            char c = a.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
    }

    static boolean checkSecondString(String b, Map<Character, Integer> map) {
        for(int i=0; i<b.length(); ++i) {
            char c = b.charAt(i);
            if(!map.containsKey(c)) {
                return false;
            } else {
                int count = map.get(c);
                if(count == 1) {
                    map.remove(c);
                } else {
                    map.put(c, count - 1);
                }
            }
        }
        return true;
    }
}
