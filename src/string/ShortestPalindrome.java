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
		System.out.println(shortestPalindrome2("aacecbaa"));
	}
	public static String shortestPalindrome2(String s) {
		int j = 0;
	    for (int i = s.length() - 1; i >= 0; i--) {
	        if (s.charAt(i) == s.charAt(j)) { 
	        		j += 1; 
	        }
	    }
	    if (j == s.length()) { return s; }
	    String suffix = s.substring(j);
	    return new StringBuffer(suffix).reverse().toString() + shortestPalindrome2(s.substring(0, j)) + suffix;
	}
	// 0, 1
	// 0, 2    1, 1
	// 0, 3    1, 2
	// 0, 4    1, 3     2, 2
	// 0, 5    1, 4     2, 3
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
