package com.codingPractice.app.dataStructure;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
	public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        int depth = 0;
        int breadth = 1;
        int temp = 0;
        while(depth<rowIndex) {
        	if(breadth==0) {
        		depth++; 
        		list.add(1);
        		breadth = list.size();
        		temp = 0;
        	} else {
	        	list.add(temp+list.get(0));
	        	temp = list.remove(0);
	        	breadth--;
        	}
        }
        return list;
    }
	public static void main(String[] args) {
		List<Integer> list = getRow(4);
		for(int i=0; i<list.size(); ++i) 
			System.out.print(list.get(i)+" ");
	}
}
