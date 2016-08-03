package com.codingPractice.app.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class Anagrams {
	public static List<String> anagrams(String[] strs) {
		List<String> l = new ArrayList<String>();
        Hashtable<String, List<String>> table = new Hashtable<String, List<String>>();
        for(int i=0; i<strs.length; ++i) {
        	String prototype = strs[i];
        	char[] array = prototype.toCharArray();
        	Arrays.sort(array);
        	String temp = new String(array);
        	if(!table.containsKey(temp)) {
        		List<String> list = new ArrayList<String>();
        		list.add(prototype);
        		table.put(temp, list);
        	} else {
        		List<String> list = table.get(temp);
        		if(list.size()==1) l.add(list.get(0));
        		l.add(prototype);
        		list.add(prototype);
        	}
        }
        return l;
    }
	public static void main(String[] args) {
		 String[] s = {"abc", "bca", "bac", "bbb", "bbca", "abcb"};
		 List<String> list = anagrams(s);
		 for(int i=0; i<list.size(); ++i) {
			 System.out.println(list.get(i));
		 }
		
		
		
	}
}
