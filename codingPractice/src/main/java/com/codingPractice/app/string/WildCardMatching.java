package com.codingPractice.app.string;

public class WildCardMatching {
	public boolean isMatch(String s, String p) {
        // write your code here
        if(s == null && p== null) return true;
        if(s.length() == 0 && p.length() == 0) return true;
        boolean[][] matrix = new boolean[s.length()+1][p.length()+1];
        matrix[0][0] = true;
        for(int i=1; i<=s.length(); ++i)
            if(matrix[i-1][0] && s.charAt(i-1) == '*') 
                matrix[i][0] = true;
        for(int i=1; i<=p.length(); ++i)
            if(matrix[0][i-1] && p.charAt(i-1) == '*')
                matrix[0][i] = true;
        for(int i=1; i<=s.length(); ++i) {
            char ss = s.charAt(i-1);
            for(int j=1; j<=p.length(); ++j) {
                char pp = p.charAt(j-1);
                if(ss == '*' || pp == '*') {
                    if(matrix[i-1][j-1] || matrix[i][j-1] || matrix[i-1][j])
                        matrix[i][j] = true;
                } else if(matrix[i-1][j-1]) {
                    if(ss == '?' || pp =='?' || ss == pp)
                        matrix[i][j] = true;
                }
            }
        }
        return matrix[s.length()][p.length()];
    }
	
	public static void main(String[] args) {
		System.out.println(new WildCardMatching().isMatch("aa", "aa"));
	}
}
