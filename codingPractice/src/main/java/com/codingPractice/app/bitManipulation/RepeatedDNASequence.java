package com.codingPractice.app.bitManipulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNASequence {
	public static List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<String>();
		if(s.length()<=10) return list;
        Map<Integer,Boolean> map = new HashMap<Integer,Boolean>();
        int temp = 0;
        for(int i=0; i<10; ++i)
        	temp = temp<<3|(s.charAt(i)&7);
        map.put(temp,false);
        for(int i=10; i<s.length(); ++i) {
        	temp = 0x3FFFFFFF&(temp<<3)|(s.charAt(i)&7);
        	if(map.containsKey(temp)) {
        		if(map.get(temp)!=true) {
            		list.add(s.substring(i-9, i+1));
            		map.put(temp,true);
        		}
        	}
        	else map.put(temp,false);
        }
        return list;
    }
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list = findRepeatedDnaSequences("GAGAGAGAGAGA");
		for(int i=0; i<list.size(); ++i) {
			System.out.println(list.get(i));
		}
	}
}
