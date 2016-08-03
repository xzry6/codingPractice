package com.codingPractice.app.pocketGemsCoding.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreakII {
	Map<String, List<String>> map = new HashMap<String, List<String>>();
	
	public List<String> wordBreak(String s, Set<String> wordDict) {
		List<String> list = new ArrayList<String>();
        // Deal with null and empty value first.
		if(s.length() == 0) {
			list.add("");
			return list;
		}
		// Return map value if key exists.
        if(map.containsKey(s)) return map.get(s);
        // Backtrack the list and return the list.
        for(int i=1; i<=s.length(); ++i) {
        		String substring = s.substring(0, i);
        		if(!wordDict.contains(substring)) continue;
        		List<String> temp = wordBreak(s.substring(i), wordDict);
        		for(String t:temp) {
        			String word = substring;
        			if(t.length() == 0) word += t;
        			else word += " " + t;
        			list.add(word);
        		}
        }
        map.put(s, list);
        return list;
    }

    public static void main(String[] args) {
    		WordBreakII wb2 = new WordBreakII();
    		Set<String> dict = new HashSet<String>();
    		dict.add("a");
    		dict.add("aa");
    		dict.add("aaa");
    		dict.add("aaaa");
    		dict.add("aaaaa");
    		dict.add("aaaaaa");
    		dict.add("aaaaaaa");
    		dict.add("aaaaaaaa");
    		dict.add("aaaaaaaaa");
    		dict.add("aaaaaaaaaa");
    		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    		System.out.println(wb2.wordBreak(s, dict));
    }
}
