package com.codingPractice.app.array;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
	public static String largestNumber(int[] num) {
        String[] strs = new String[num.length];
        String str = new String();
        for(int i=0; i<num.length; ++i)
        	strs[i] = Integer.toString(num[i]);
        Arrays.sort(strs, new StringCom());
        for(int i=num.length-1; i>=0; --i){
        	if(str.length()==0&&strs[i].equals("0")) continue;
        	str+=strs[i];
        }
        if(str.length()==0) return "0";
        else return str;
    }
	public static void main(String[] args){
		int[] num = {0,0};
		System.out.println(largestNumber(num));
	}
}
class StringCom implements Comparator<String>{
	public int compare(String s1, String s2){
		String s12 = s1+s2;
		String s21 = s2+s1;
		return Integer.parseInt(s12)-Integer.parseInt(s21);
	}
}
