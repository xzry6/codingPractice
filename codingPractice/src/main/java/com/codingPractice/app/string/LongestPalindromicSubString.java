package com.codingPractice.app.string;

public class LongestPalindromicSubString {
	public String longestPalindrome(String s) {
        // Write your code here
        if(s == null) return null;
        if(s.length() == 0) return new String();
        int max = 1;
        int begin = 0;
        int finish = 1;
        for(int i=0; i<s.length(); ++i) {
            int start = i;
            int end = i;
            while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            		start --;
            		end ++;
            }
            if(end-start-1 > max) {
                max = end-start-1;
                begin = start+1;
                finish = end;
            }
            
            start = i;
            end = i+1;
            while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            		start --;
            		end ++;
            }
            if(end-start-1 > max) {
                max = end-start-1;
                begin = start+1;
                finish = end;
            }
        }
        return s.substring(begin, finish);
    }
	
	public static void main(String[] args) {
		System.out.println(new LongestPalindromicSubString().longestPalindrome("abb"));
	}
}
