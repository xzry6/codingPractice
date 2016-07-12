package string;

import java.util.HashMap;
import java.util.Map;

/**
 * An abbreviation of a word follows the form <first letter><number><last letter>.
 * Below are some examples of word abbreviations:
 * a) it                      --> it    (no abbreviation)
 *    
 *      1
 * b) d|o|g                   --> d1g
 *
 *               1    1  1
 *      1---5----0----5--8
 * c) i|nternationalizatio|n  --> i18n
 *
 *               1
 *      1---5----0
 * d) l|ocalizatio|n          --> l10n
 * 
 * Assume you have a dictionary and given a word,
 * find whether its abbreviation is unique in the dictionary.
 * A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.
 * 
 * Example: 
 * Given dictionary = [ "deer", "door", "cake", "card" ]
 * 
 * isUnique("dear") -> false
 * isUnique("cart") -> true
 * isUnique("cane") -> false
 * isUnique("make") -> true
 * 
 * 
 * @author Sean
 *
 */
public class ValidWordAbbr {
	public static void main(String[] args) {
		String[] dictionary = {"hello"};
		ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
		System.out.println(vwa.isUnique("hello"));
	}

	Map<String, String> map;

    public ValidWordAbbr(String[] dictionary) {
    		this.map = new HashMap<String, String>();
        for(String word:dictionary) {
        		String s = abbreviate(word);
    		    if(map.containsKey(s) && !word.equals(map.get(s))) map.put(s, null);
        		else map.put(s, word);
        }
    }

    public boolean isUnique(String word) {
        if(word == null) return false;
        String s = abbreviate(word);

        if(!map.containsKey(s)) return true;
        return word.equals(map.get(s));
    }

    private String abbreviate(String s) {
        if(s == null) return null;
        if(s.length() <= 2) return s;

        StringBuilder sb = new StringBuilder();
        return sb.append(s.charAt(0))
                 .append(s.length() - 2)
                 .append(s.charAt(s.length() - 1))
                 .toString();
    }
}
