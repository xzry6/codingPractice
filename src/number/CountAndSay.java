package number;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * 
 * Note: The sequence of integers will be represented as a string.
 * 
 * @author Sean
 *
 */
public class CountAndSay {
	public String countAndSay(int n) {
		String s = "1";
        while(--n > 0) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for(int i = 1; i < s.length(); ++ i) {
                if(s.charAt(i) != s.charAt(i - 1)) {
                    sb.append(count).append(s.charAt(i - 1));
                    count = 1;
                } else count ++;
            }
            sb.append(count).append(s.charAt(s.length() - 1));
            s = sb.toString();
        }
        return s;
        
    }
}
