package string;

/**
 * Given a string S, you are allowed to convert it to a
 * palindrome by adding characters in front of it.
 * Find and return the shortest palindrome you can find
 * by performing this transformation.
 * 
 * For example:
 * 
 * Given "aacecaaa", return "aaacecaaa".
 * Given "abcd", return "dcbabcd".
 * 
 * @author Sean
 *
 */
public class ShortestPalindrome {
	public static void main(String[] args) {
		System.out.println(shortestPalindrome("abcd"));
	}

	public static String shortestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";

        char[] arr = s.toCharArray();
        int max = 1;
        for(int i = 1; i < arr.length; ++ i) {
            int begin = 0;
            int end = i;
            while(begin < end) {
                if(arr[begin] != arr[end]) break;
                begin ++;
                end --;
            }
            if(begin >= end) max = i + 1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = arr.length - 1; i >= max; -- i) sb.append(arr[i]);
        for(int i = 0; i < arr.length; ++ i) sb.append(arr[i]);
        return sb.toString();
    }
}
