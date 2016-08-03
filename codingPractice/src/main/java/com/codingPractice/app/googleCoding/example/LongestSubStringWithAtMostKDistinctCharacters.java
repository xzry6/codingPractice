package com.codingPractice.app.googleCoding.example;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class LongestSubStringWithAtMostKDistinctCharacters {
	/**
     * @param s : A string
     * @return : The length of the longest substring 
     *           that contains at most k distinct characters.
     */

    // Sub class.
    static class CharIndex {
        char c;
        int i;
        CharIndex(char c, int i) {
            this.c = c;
            this.i = i;
        }
    }

    // Comparator.
    static Comparator<CharIndex> comparator = new Comparator<CharIndex>() {
        @Override
        public int compare(CharIndex ci1, CharIndex ci2) {
            return ci1.i - ci2.i;
        }
    };

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {

        // Deal with edge cases first.
        if(s == null || k == 0) return 0;
        // Have a map storing (character, lastIndex) pair.
        Map<Character, CharIndex> map = new HashMap<Character, CharIndex>();
        Queue<CharIndex> queue = new PriorityQueue<CharIndex>(10000, comparator);

        int max = 0;
        int local = 0;
        // Loop.
        for(int i=0; i<s.length(); ++i) {
            char c = s.charAt(i);
            CharIndex CI = new CharIndex(c, i);
            if(map.containsKey(c))
                queue.remove(map.get(c));
            map.put(c, CI);
            queue.offer(CI);

            if(map.size() > k) {
                CharIndex removedCI = queue.poll();
                map.remove(removedCI.c);
                local = i - removedCI.i;
            } else {
                local ++;
            }
            max = Math.max(max, local);
        }
        // Return max.
        return max;
    }

    public static void main(String[] args) {
    		String s = "kb";
    		int k = 16;
    		System.out.println(lengthOfLongestSubstringKDistinct(s, k));
    }
}
