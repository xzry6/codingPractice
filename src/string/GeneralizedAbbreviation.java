package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a function to generate the generalized abbreviations of a word.
 * 
 * Example:
 * Given word = "word", return the following list (order does not matter):
 * [
 *  "word", "1ord", "w1rd", "wo1d",
 *  "wor1", "2rd","w2d", "wo2",
 *  "1o1d", "1or1", "w1r1", "1o2",
 *  "2r1", "3d", "w3", "4"
 * ]
 * 
 * @author Sean
 *
 */
public class GeneralizedAbbreviation {
	public static void main(String[] args) {
		GeneralizedAbbreviation ga = new GeneralizedAbbreviation();
		List<String> list = ga.generateAbbreviations("");
		for(String s:list) System.out.println(s);
	}
	public List<String> generateAbbreviations(String word) {
        List<String> list = new ArrayList<String>();
        if(word == null) return list;

        recursive(list, new StringBuilder(), word, 0);
        return list;
    }

    public void recursive(List<String> list, StringBuilder sb, String word, int p) {
        if(p >= word.length()) {
            list.add(sb.toString());
            return;
        }

        for(int i = p ; i <= word.length(); ++ i) {
            int diff = i - p;
            if(diff != 0) sb.append(diff);
            if(i != word.length()) sb.append(word.charAt(i));

            recursive(list, sb, word, i + 1);

            sb.deleteCharAt(sb.length() - 1);
            while(sb.length() != 0 && Character.isDigit(sb.charAt(sb.length() - 1)))
                sb.deleteCharAt(sb.length() - 1);
        }
    }
}
