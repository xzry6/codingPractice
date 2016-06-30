package dataStructure;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> list = new ArrayList<Interval>();
        if(newInterval==null) return intervals;
        if(intervals.size()==0) {
        	if(newInterval!=null)
        		list.add(newInterval);
        	return list;
        }
        boolean bool = true;
        int begin = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        for(int i=0; i<intervals.size(); ++i) {
        	Interval temp = intervals.get(i);
        	if(temp.end<newInterval.start) list.add(temp);
        	else if(temp.start>newInterval.end) {
        		if(bool) {
            		Interval newone = new Interval(Math.min(begin, newInterval.start),Math.max(end,newInterval.end));
            		list.add(newone);
        		}
        		bool = false;
        		list.add(temp);
        	}
        	else {
        		begin = Math.min(begin,Math.min(temp.start, newInterval.start));
        		end = Math.max(temp.end,newInterval.end);
        	}
        }
        if(bool) list.add(new Interval(Math.min(begin, newInterval.start),Math.max(end,newInterval.end)));
        return list;
    }
	public static void main(String[] args) {
		List<Interval> list = new ArrayList<Interval>();
		list.add(new Interval(1,2));
		list.add(new Interval(3,5));
		list.add(new Interval(6,7));
		list.add(new Interval(8,10));
		list.add(new Interval(12,16));
		Interval a = new Interval(-1,0);
		List<Interval> aa = insert(list,a);
		for(int i=0; i<aa.size(); ++i) {
			System.out.print(aa.get(i).start+" ");
			System.out.println(aa.get(i).end);
			
		}
		
		
	}
}
