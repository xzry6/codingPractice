package com.codingPractice.app.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public static List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        int p1;
        int p2;
        int sum;
        for(int i=0; i<num.length; ++i){
	        	sum = -num[i];
	        	p1 = i+1;
	        	p2 = num.length-1;
	        	while(p1<p2){
	        		if(num[p1]+num[p2]==sum){
	                	List<Integer> temp = new ArrayList<Integer>();
	        			temp.add(Math.min(num[p1], num[i]));
	        			temp.add(Math.min(Math.max(num[p1], num[i]), num[p2]));
	        			temp.add(Math.max(num[p2], num[i]));
	        			for(int t:temp)
	        				System.out.print(t+" ");
	        			System.out.println();
	        			//temp.add(num[i]);
	        			//temp.add(num[p1]);
	        			//temp.add(num[p2]);
	        			if(!list.contains(temp))
	        				list.add(temp);
	        			while(p1<p2&&num[p1]==num[++p1]);
	        			while(p1<p2&&num[p2]==num[--p2]);
	        		}
	        		else if(num[p1]+num[p2]>sum) p2--;
	        		else if(num[p1]+num[p2]<sum) p1++;
	        	}
	        	while(i+1<num.length&&num[i]==num[i+1]) i++;
        }
        return list;
    }
	public static void main(String[] args){
		int[] num = {-2,-3,-4,-5,-100,99,1,4,4,4,5,1,0,-1,2,3,4,5};
		ArrayList<ArrayList<Integer>> list = threeSum2(num);
		for(int n=0; n<list.size(); ++n){
			for(int i=0; i<list.get(n).size(); ++i){
				System.out.print(list.get(n).get(i)+" ");
			}
			System.out.println();
		}
	}
	
	 public static ArrayList<ArrayList<Integer>> threeSum2(int[] numbers) {
	        // write your code here
	        if(numbers == null || numbers.length == 0) return null;
	        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	        Arrays.sort(numbers);
	        
	        for(int i=2; i<numbers.length; ++i) {
	            int p1 = 0;
	            int p2 = i-1;
	            while(p1<p2) {
	                int sum = numbers[i]+numbers[p1]+numbers[p2];
                    System.out.println(numbers[p1]+" "+numbers[p2]+" "+numbers[i]);
	                if(sum == 0) {
	                    ArrayList<Integer> temp = new ArrayList<Integer>();
	                    temp.add(numbers[p1]);
	                    temp.add(numbers[p2]);
	                    temp.add(numbers[i]);
	                    list.add(temp);
	                    while(p2 > p1 && numbers[p2] == numbers[--p2]);
	                    while(p1 < p2 && numbers[p1] == numbers[++p1]);
	                } else if(sum > 0) p2--;
	                else p1++;
	            }
	            while(i != numbers.length-1 && numbers[i] == numbers[i+1]) i++;
	        }
	        
	        return list;
	    }
	
	
}
