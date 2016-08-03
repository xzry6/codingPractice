package com.codingPractice.app.dataStructure;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(numRows==0) return list;
        List<Integer> top = new ArrayList<Integer>();
        top.add(1);
        list.add(top);
        int count = 0;
        while(count<numRows-1) {
        	List<Integer> temp = list.get(count++);
        	top = new ArrayList<Integer>();
        	top.add(1);
        	for(int j=0; j<temp.size()-1; ++j)  		
        		top.add(temp.get(j)+temp.get(j+1));
        	top.add(1);
        	list.add(top);
        }
        return list;
    }
	public static void main(String[] args) {
		List<List<Integer>> list = generate(3);
		for(int i=0; i<list.size(); ++i) {
			List<Integer> temp = list.get(i);
			for(int j=0; j<temp.size(); ++j) {
				System.out.print(temp.get(j)+" ");
			}
			System.out.println();
		}
	}
}
