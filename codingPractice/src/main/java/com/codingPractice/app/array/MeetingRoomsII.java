package com.codingPractice.app.array;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an array of meeting time intervals consisting of 
 * start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * find the minimum number of conference rooms required.
 * 
 * For example,
 * Given [[0, 30],[5, 10],[15, 20]],
 * return 2.
 * 
 * @author Sean
 *
 */
public class MeetingRoomsII {
	

	private Comparator<Interval> comparator = new Comparator<Interval>() {
        @Override
        public int compare(Interval i1, Interval i2) {
            return i1.start - i2.start;
        }
    };

    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return 0;

        Queue<Interval> q1 = new PriorityQueue<Interval>(comparator);
        Queue<Interval> q2 = new PriorityQueue<Interval>(comparator);
        int rooms = 0;
        for(Interval interval:intervals) q1.offer(interval);
        
        while(!q1.isEmpty() || !q2.isEmpty()) {
            Queue<Interval> cur = rooms % 2 == 1 ? q2 : q1;
            Queue<Interval> next = rooms % 2 == 1 ? q1 : q2;
            Interval interval = cur.poll();
            int end = interval.end;
            rooms ++;

            while(!cur.isEmpty()) {
                Interval tmp = cur.poll();
                if(tmp.start < end) next.offer(tmp);
                else end = tmp.end;
            }
        }

        return rooms;
    }

    public static void main(String[] args) {
    		MeetingRoomsII mr2 = new MeetingRoomsII();
    		Interval[] intervals = {new Interval(2, 7)};
    		System.out.println(mr2.minMeetingRooms(intervals));
    }
}

class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}
