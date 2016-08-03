package com.codingPractice.app.array;

import java.util.ArrayList;
import java.util.List;

public class MergeKSortedArrays {
	public List<Integer> mergekSortedArrays(int[][] arrays) {
        // Write your code here
        if(arrays == null || arrays.length == 0 || arrays[0].length == 0) return null;
        List<Integer> list = new ArrayList<Integer>();
        int[] p = new int[arrays.length];
        while(!check(p, arrays)) {
            int min = Integer.MAX_VALUE;
            int index = 0;
            for(int i=0; i<p.length; ++i) {
                if(p[i] >= arrays[i].length) continue;
                if(min > arrays[i][p[i]]) {
                    min = arrays[i][p[i]];
                    index = i;
                }
            }
            list.add(min);
            p[index]++;
        }
        return list;
    }
    
    private boolean check(int[] p, int[][] arrays) {
        for(int i=0; i<p.length; ++i)
            if(p[i] < arrays[i].length) return false;
        return true;
    }
    public static void main(String[] args) {
    		MergeKSortedArrays mksa = new MergeKSortedArrays();
    		int[][] arrays = {
    							{1,3,5,7},
    							{2,4,6},
    							{0,8,9,10,11}
    		};
    		List<Integer> list = mksa.mergekSortedArrays(arrays);
    		for(int i:list)
    			System.out.println(i+" ");
    		String a = "aa";
    		System.out.println(a.compareTo("bb"));
    		
    }
}
