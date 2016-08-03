package com.codingPractice.app.dynamicProgramming;

public class HIndex {
	public int hIndex(int[] citations) {
        int num = citations.length;
        int[] count = new int[num+1];
        for(int i=0; i<num; ++i) {
        		if(citations[i]>num) count[num]++;
        		else count[citations[i]]++;
        }
        for(int i=num; i>=1; --i) {
        		if(count[i]>=i) return i;
        		else count[i-1] += count[i];
        }
        return 0;
    }
}
