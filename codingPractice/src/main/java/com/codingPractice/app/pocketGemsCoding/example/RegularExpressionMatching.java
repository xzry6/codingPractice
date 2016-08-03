package com.codingPractice.app.pocketGemsCoding.example;

public class RegularExpressionMatching {
	/**
     * @param s: A string 
     * @param p: A string includes "." and "*"
     * @return: A boolean
     */
    
	public static void main(String[] args) {
		String s = "bbbba";
		String p = ".*a*a";
		RegularExpressionMatching rem = new RegularExpressionMatching();
		System.out.print(rem.isMatch2(s, p));
	}

    // Global Map.
    boolean[][] map;

    public boolean isMatch2(String s, String p) {
        if(p == null) return s == null;
        if(p.length() == 0) return s.length() == 0;
        map = new boolean[s.length() + 1][p.length() + 1];

        return isMatch(s, p, 0, 0);
    }

    private boolean isMatch(String s, String p, int is, int ip) {
        if(ip == p.length()) return is == s.length();
        if(map[is][ip]) return false;
        map[is][ip] = true;

        // If next is not '*'.
        if(ip == p.length() - 1 || p.charAt(ip + 1) != '*') {
            // Match ? (is + 1, ip + 1) : -1;
            if(is == s.length() || (p.charAt(ip) != '.' && s.charAt(is) != p.charAt(ip))) return false;
            return isMatch(s, p, is + 1, ip + 1);
        }

        // If next is '*'.
        if(is != s.length()) {
	        if(p.charAt(ip) == '.' || s.charAt(is) == p.charAt(ip)) {
	            // is + 1, ip + 2;
	        		if(isMatch(s, p, is + 1, ip + 2)) return true;
	        		// is + 1;
	        		if(isMatch(s, p, is + 1, ip)) return true;
	        }
        }
        // Not Match ? ip + 2;
        	return isMatch(s, p, is, ip + 2);
    }
}
