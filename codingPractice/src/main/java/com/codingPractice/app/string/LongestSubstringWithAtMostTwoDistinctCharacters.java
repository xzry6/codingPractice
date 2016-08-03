package com.codingPractice.app.string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LongestSubstringWithAtMostTwoDistinctCharacters {
	public static void main(String[] args) {
		LongestSubstringWithAtMostTwoDistinctCharacters l = new LongestSubstringWithAtMostTwoDistinctCharacters();
		System.out.println(l.lengthOfLongestSubstringTwoDistinct("bacc"));
	}
	public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0) return 0;

        int length = 1;
        int slow = 0;
        int fast = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        Queue<Character> queue = new LinkedList<Character>();
        while(fast < s.length()) {
            while(fast < s.length() && map.size() <= 2) {
                char c = s.charAt(fast);

                if(map.containsKey(c)) map.put(c, map.get(c) + 1);
                else map.put(c, 1);

                queue.offer(s.charAt(fast ++));
                if(map.size() <= 2)
                    length = Math.max(length, queue.size());
            }
            while(!queue.isEmpty() && slow < fast && map.size() > 2) {
                char c = queue.poll();
    
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0) map.remove(c);
    
                slow ++;
            }
        }

        return length;
	}
}
