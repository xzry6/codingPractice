package com.codingPractice.app.string;

public class PalindromicString {
	public static String longestPalindrome(String s) {
        int max = 0;
        int dis;
        int length;
        int start = 0;
        int len = 0;
        int l;
        if(s.length()<1000) l = s.length();
        else l = 1000;
		for(int i=0; i<l; ++i){
        	dis = 1;
        	length = 1;
        	while(i-dis>-1&&i+dis<l){
        		if(s.charAt(i-dis)!=s.charAt(i+dis)) break;
        		length+=2;
        		dis++;
        	}
			if(length>max){
				max = length;
				start = i-dis+1;
				len = i-dis+length+1;
    		}
			
        	if(i+1<l){
        		if(s.charAt(i)==s.charAt(i+1)){
        			dis = 1;
        			length = 2;
        			while(i-dis>-1&&i+dis+1<l){
                		if(s.charAt(i-dis)!=s.charAt(i+dis+1)) break;
                		length+=2;
                		dis++;
                	}
        			if(length>max){
        				max = length;
        				start = i-dis+1;
        				len = i-dis+length+1;
        			}
        		}
        	}
        	if(max>2*(l-i)) break;
        }
		String ss = s.substring(start, len);
		return ss;
    }
	public static void main(String[] args){
		String s = "abcabaadc";
		System.out.println(longestPalindrome(s));
	}
}
