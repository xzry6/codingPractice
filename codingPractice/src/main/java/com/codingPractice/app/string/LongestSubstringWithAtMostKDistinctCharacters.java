package com.codingPractice.app.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring T
 * that contains at most k distinct characters.
 * 
 * For example, Given s = “eceba” and k = 2,
 * T is "ece" which its length is 3.
 * 
 * @author Sean
 *
 */
public class LongestSubstringWithAtMostKDistinctCharacters {
	public static void main(String[] args) {
		LongestSubstringWithAtMostKDistinctCharacters lswamkdc = new LongestSubstringWithAtMostKDistinctCharacters();
		System.out.println(lswamkdc.lengthOfLongestSubstringKDistinct("aa", 2));
	}
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // Deal with edge cases first.
        if(s == null || s.length() == 0 || k == 0) return 0;
        
        // Variables.
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int slow = 0;
        int fast = 0;
        int max = 0;
        
        // Loop.
        while(fast < s.length()) {
            // Count <= k, move fast.
            while(map.size() <= k && fast < s.length()) {
                char c = s.charAt(fast);

                if(map.containsKey(c)) map.put(c, map.get(c) + 1);
                else map.put(c, 1);

                fast ++;
                if(map.size() <= k) max = Math.max(max, fast - slow);
            }
            // Count > k, move slow.
            while(map.size() > k && slow <= fast) {
                char c = s.charAt(slow);

                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0) map.remove(c);

                slow ++;
            }
        }

        // Return.
        return max;
    }
}
