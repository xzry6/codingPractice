package com.codingPractice.app.pocketGemsCoding.example;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class WordBreak {
	public static boolean wordBreak(String s, Set<String> dict) {
        if(s.length()==0||dict.size()==0) return false;
		boolean[] bool = new boolean[s.length()+1];
		bool[0] = true;
		for(int i=1; i<s.length()+1; ++i) {
			for(int j=0; j<i; ++j) {
				if(bool[j]&&dict.contains(s.substring(j,i))) {
					bool[i] = true;
					break;
				}
			}
		}
		return bool[s.length()];
    }
 public static boolean wordBreak2(String s, Set<String> dict) {
	if(dict.isEmpty() && s.length() == 0) return true;
    if(s == null || s.length() == 0) return false;
    if(dict.isEmpty()) return false;
    int max = getWordLength(dict);
    boolean[] bool = new boolean[s.length()+1];
    bool[0] = true;
    for(int i=1; i<bool.length; ++i) {
        for(int j=Math.max(i-max, 0); j<i; ++j) {
            if(bool[j] && dict.contains(s.substring(j, i))) {
                bool[i] = true;
                break;
            }
        }
    }
    return bool[s.length()];
}
private static int getWordLength(Set<String> dict) {
    int max = 0;
    Iterator<String> it = dict.iterator();
    while(it.hasNext()) {
        String s = it.next();
        max = Math.max(max, s.length());
    }
    return max;
}
public static boolean wordBreak3(String s, Set<String> wordDict) {
    // Deal with null and empty case.
    if(s == null) return false;
    if(s.length() == 0) return true;
    if(wordDict == null || wordDict.size() == 0) return false;
    // Create a mask recording calculated states.
    boolean[] mask = new boolean[s.length()+1];
    mask[0] = true;
    // Calculate the maximum length of word in the dict.
    int maxLength = calculateMax(wordDict);
    // Begin Loop.
    for(int i=1; i<mask.length; ++i) {
        for(int j=Math.max(0, i-maxLength); j<i; ++j) {
            // Skip the invalid states.
            if(!mask[j]) continue;
            String sub = s.substring(j, i);
            if(wordDict.contains(sub)) {
                mask[i] = true;
                break;
            }
        }
    }
    // Return result.
    return mask[s.length()];
}
//Calculate maximum length of words in the dict.
private static int calculateMax(Set<String> wordDict) {
    // Have a max variable.
    int max = Integer.MIN_VALUE;
    // Have an iterator traversing the set.
    Iterator<String> iterator = wordDict.iterator();
    while(iterator.hasNext()) {
        String temp = iterator.next();
        max = Math.max(max, temp.length());
    }
    // Return max number.
    return max;
}
	public static void main(String[] args) {		
		Set<String> dict = new HashSet<String>();
//		dict.add("dog");
//		dict.add("s");
//		dict.add("gs");
//		dict.add("bc");
//		dict.add("fg");
//		dict.add("abcd");
//		dict.add("efg");
		dict.add("a");
		String s = "a";
		System.out.println(wordBreak3(s,dict));
		
	}
}
