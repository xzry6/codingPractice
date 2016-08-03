package com.codingPractice.app.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class WordLadderII {
	public static List<List<String>> findLadders(String start, String end, Set<String> dict) {
		List<List<String>> list = new ArrayList<List<String>>();
		List<List<String>> ob = new ArrayList<List<String>>();
	    Stack<String> visited = new Stack<String>();
		if(dict.isEmpty()&&!start.equals(end)) return list;
	    List<String> top = new ArrayList<String>();
	    top.add(start);
	    list.add(top);
	    if(start.equals(end)) return list;
	    int count = 1;
	    
	    while(!list.isEmpty()) {
	    	if(count==0&&!ob.isEmpty()) break;
	    	if(count==0) {
	    		while(!visited.isEmpty()) 
	    		    dict.remove(visited.pop());
	    		count = list.size();
	    	}
	    	List<String> original = list.remove(0);
	    	count--;
	    	String s = original.get(original.size()-1);
	    	for(int i=0; i<s.length(); ++i) {
	    		StringBuilder builder = new StringBuilder(s); 
	    		char c = s.charAt(i);
	    		for(char t='a'; t<='z'; ++t) {
	    			if(t==c) continue;
	    			builder.setCharAt(i,t);
	                String substitude = builder.toString();
	    			if(substitude.equals(end)) {
	    				List<String> mutated = new ArrayList<String>(original);
	    				mutated.add(substitude);
	    				ob.add(mutated);
	    			}
	    			else if(dict.contains(substitude)) {
	    				visited.push(substitude);
	    				List<String> mutated = new ArrayList<String>(original);
	    				mutated.add(substitude);
	    				list.add(mutated);
	    			} 
	    		}
	    	}
	    }
	    return ob;
    }
	
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("ted");
		set.add("tex");
		set.add("red");
		set.add("tax");
		set.add("tad");
		set.add("den");
		set.add("rex");
		set.add("pee");
		List<List<String>> list = findLadders("red","tax",set);
		for(int i=0; i<list.size(); ++i) {
			List<String> temp = list.get(i);
			for(int j=0; j<temp.size(); ++j) {
				System.out.print(temp.get(j)+" ");
			}
			System.out.println();
		}
	}
}
