package com.codingPractice.app.string;

public class LongestSubString {
	public static int lengthOfLongestSubstring(String s) {
		if(s.isEmpty()) return 0;
        char[] cha = s.toCharArray();
        int flag;
        String newS = new String();
        int temp = 0;
        for(int i=0; i<cha.length; ++i){
        	flag = 0;
        	for(int j=0; j<newS.length(); ++j){
        		if(cha[i]==newS.charAt(j)) {
        			flag = j+1;
        			break;
        		}
        	}
        	if(flag==0) {
        		newS += cha[i];
        		if(newS.length()>temp) temp = newS.length();
        	}
        	else {
        		System.out.println(newS.length());
       			newS = newS.substring(flag);
       			newS += cha[i];
       		}
        }
        return temp;
    }
	public static int lengthOfLongestSubstring2(String s) {
		if(s.isEmpty()) return 0;
	       char[] cha = s.toCharArray();
	        int pos = 0;
	        int length = 0;
	        int max = 0;
	        for(int i=0; i<cha.length; ++i){
	        	for(int j=0; j<length; ++j){
	        		if(cha[i]==s.charAt(pos+j)){
	        			pos = pos+j+1;
	            		System.out.println(length);
	        			length = length-j-1;
	        			break;
	        		}
	        	}
	        	length++;
        		if(length>max) max = length;
	        }
	        return max;
    }
	public static void main(String[] args){
		String s = "qopubjguxhxdipfzwswybgfylqvjzhar";
		System.out.println(lengthOfLongestSubstring(s));
		System.out.println(lengthOfLongestSubstring2(s));
	}
}
