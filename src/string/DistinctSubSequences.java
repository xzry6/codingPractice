package string;

import java.util.HashMap;

public class DistinctSubSequences {
	public static int numDistinct(String S, String T) {
        if(T.length()==0||S.length()<T.length()) return 0;
        int s = S.length();
        int t = T.length();
        int[][] table = new int[s+1][t+1];
        for(int j=0; j<s+1; ++j) table[j][0] = 1;
        for(int j=1; j<s+1; ++j) {
	        	for(int i=1; i<t+1; ++i) {
	        		table[j][i] = table[j-1][i];
	        		if(S.charAt(j-1)==T.charAt(i-1)) 
	        			table[j][i] += table[j-1][i-1];
	        	}
        }
        return table[s][t];
    }
	public static void main(String[] args) {
		String S = "addd";
		String T = "dd";
		System.out.println(numDistinct2(S,T));
		
		
	}
	public static int numDistinct2(String S, String T) {
        int[] arr = new int[T.length()+1];
        for(int i=0; i<S.length(); ++i) {
            arr[0] = 1;
            for(int j=arr.length-1; j>=1; --j) 
                if(T.charAt(j-1) == S.charAt(i)) 
                    arr[j] += arr[j-1];
        }
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        return arr[T.length()];
	}
}
