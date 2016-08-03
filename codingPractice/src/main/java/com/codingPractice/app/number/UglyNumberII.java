package com.codingPractice.app.number;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class UglyNumberII {
	public int nthUglyNumber(int n) {
		int[] p = {0,0,0};
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        for(int i=1; i<n; ++i) {
        	int[] v = {list.get(p[0])*2,list.get(p[1])*3,list.get(p[2])*5};
        	int minimum = Math.min(Math.min(v[0],v[1]),v[2]);
        	if(minimum==v[0]) p[0]++;
        	if(minimum==v[1]) p[1]++;
        	if(minimum==v[2]) p[2]++;
        	list.add(minimum);
        }
        return list.get(list.size()-1);
    }
	public long kthPrimeNumber2(int k) {
        // write your code here
        PriorityQueue<Long> queue = new PriorityQueue<Long>(10000);
        queue.add((long)3);
        queue.add((long)5);
        queue.add((long)7);
        while(queue.size() < k) {
            int size = queue.size();
            for(int i=0; i<size; ++i) {
                long temp = queue.poll();
                if(!queue.contains(temp*3)) queue.add(temp*3);
                if(!queue.contains(temp*5)) queue.add(temp*5);
                if(!queue.contains(temp*7)) queue.add(temp*7);
                k--;
            }
            
        }
        long result = Long.MAX_VALUE;
        while(k-- > 0) 
            result = queue.poll();
        return result;
    }
	public static void main(String[] args) {
		UglyNumberII un2 = new UglyNumberII();
		System.out.println(un2.kthPrimeNumber2(11));
	}
}
