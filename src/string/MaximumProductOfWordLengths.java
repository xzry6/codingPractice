package string;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string array words,
 * find the maximum value of length(word[i]) * length(word[j])
 * where the two words do not share common letters.
 * You may assume that each word will contain only lower case letters.
 * If no such two words exist, return 0.
 * 
 * Example 1:
 * Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
 * Return 16
 * The two words can be "abcw", "xtfn".
 * 
 * Example 2:
 * Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
 * Return 4
 * The two words can be "ab", "cd".
 * 
 * Example 3:
 * Given ["a", "aa", "aaa", "aaaa"]
 * Return 0
 * No such pair of words.
 * 
 * @author Sean
 *
 */
public class MaximumProductOfWordLengths {
	public int maxProduct(String[] words) {
        if(words == null || words.length < 2) return 0;

        int max = 0;
        for(int i = 0; i < words.length; ++ i) {
        		Set<Character> set = new HashSet<Character>();
        		for(int j = 0; j < words[i].length(); ++ j)
        			set.add(words[i].charAt(j));
        		for(int k = i + 1; k < words.length; ++ k)
        			if(!checkDup(set, words[k]))
        				max = Math.max(max, words[i].length() * words[k].length());
        }

        return max;
    }

	private boolean checkDup(Set<Character> set, String word) {
		for(int i = 0; i < word.length(); ++ i)
			if(set.contains(word.charAt(i))) return true;
		return false;
	}
}
