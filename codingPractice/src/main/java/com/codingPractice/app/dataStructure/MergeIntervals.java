package com.codingPractice.app.dataStructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
	
	public static List<Interval> merge(List<Interval> intervals) {
		if(intervals.size()<=1) return intervals;
		Collections.sort(intervals,new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return Integer.compare(i1.start, i2.start);
			}
		});
		int p = 1;
		while(p<intervals.size()) {
        	Interval pre = intervals.get(p-1);
        	Interval cur = intervals.get(p);
        	if(pre.end>=cur.start) {
        		intervals.remove(p);
        		pre.start = Math.min(pre.start, cur.start);
        		pre.end = Math.max(pre.end, cur.end);
        		p--;
        	}
        	p++;
    	}
        return intervals;
    }
	
	public static void main(String[] args) {
		List<Interval> list = new ArrayList<Interval>();
		list.add(new Interval(4,5));
		list.add(new Interval(2,4));
		list.add(new Interval(4,6));
		list.add(new Interval(3,4));
		list.add(new Interval(0,0));
		list.add(new Interval(1,1));
		list.add(new Interval(3,5));
		list.add(new Interval(2,2));
		List<Interval> aa = merge(list);
		for(int i=0; i<aa.size(); ++i) {
			System.out.print(aa.get(i).start+" ");
			System.out.println(aa.get(i).end);
			
		}
	}
}
