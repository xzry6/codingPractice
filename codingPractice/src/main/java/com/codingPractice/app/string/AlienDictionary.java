package com.codingPractice.app.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * There is a new alien language which uses the latin alphabet.
 * However, the order among letters are unknown to you.
 * You receive a list of words from the dictionary,
 * where words are sorted lexicographically by the rules of this new language.
 * Derive the order of letters in this language.
 * 
 * For example,
 * Given the following words in dictionary,
 * 
 * [
 * 	"wrt",
 *  "wrf",
 *  "er",
 *  "ett",
 *  "rftt"
 *  ]
 * The correct order is: "wertf".
 * 
 * Note:
 * You may assume all letters are in lowercase.
 * If the order is invalid, return an empty string.
 * There may be multiple valid order of letters,
 * return any one of them is fine.
 * 
 * @author Sean
 *
 */
public class AlienDictionary {
	public String alienOrder(String[] words) {
        StringBuilder sb = new StringBuilder();
        if(words == null || words.length == 0) return sb.toString();

        Map<Character, Set<Character>> map = new HashMap<Character, Set<Character>>();
        Map<Character, Integer> count = new HashMap<Character, Integer>();
        for(String word:words)
            for(char c:word.toCharArray()) count.put(c, 0);

        for(int i = 0; i < words.length - 1; ++ i) {
            String cur = words[i];
            String next = words[i + 1];
            for(int j = 0; j < Math.min(cur.length(), next.length()); ++ j) {
                char cc = cur.charAt(j);
                char cn = next.charAt(j);
                if(cc == cn) continue;
                if(!map.containsKey(cc)) map.put(cc, new HashSet<Character>());
                if(map.get(cc).add(cn)) count.put(cn, count.get(cn) + 1);
                break;
            }
        }

        Queue<Character> queue = new LinkedList<Character>();
        for(char c:count.keySet())
            if(count.get(c) == 0) queue.offer(c);

        while(!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            if(!map.containsKey(c)) continue;
            for(char next:map.get(c)) {
                count.put(next, count.get(next) - 1);
                if(count.get(next) == 0) queue.offer(next);
            }
        }

        return sb.length() == count.size() ? sb.toString() : "";
    }
}
