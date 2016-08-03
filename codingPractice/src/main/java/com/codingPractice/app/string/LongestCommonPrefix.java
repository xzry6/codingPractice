package com.codingPractice.app.string;

import java.util.Arrays;

public class LongestCommonPrefix {
	public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        String prefix = strs[0];
        if(strs.length==1) return prefix;
        for(int n=1; n<strs.length; ++n){
        	String temp = strs[n];
        	if(temp==null||temp.length()==0||prefix.length()==0) 
        		return "";
        	int num = prefix.length();
        	while(num!=0){
        		if(temp.length()>=num&&temp.substring(0,num).equals(prefix)) break;
        		num -= 1;
        		prefix = prefix.substring(0, num);
        	}
        }
        return prefix;
    }
	public static void main(String[] args){
		String[] s = new String[3];
		s[0] = "accc";
		s[1] = "acc";
		s[2] = "cac";
		System.out.println(Arrays.toString(s));
		System.out.println(longestCommonPrefix(s));
	}
}
