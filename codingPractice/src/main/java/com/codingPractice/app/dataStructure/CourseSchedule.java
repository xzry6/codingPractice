package com.codingPractice.app.dataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0 || prerequisites == null || prerequisites.length ==0) return true;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Map<Integer, List<Integer>> neighbor = new HashMap<Integer, List<Integer>>();
        for(int i=0; i<numCourses; ++i) {
            map.put(i, 0);
            neighbor.put(i, new ArrayList<Integer>());
        }
        for(int[] pair:prerequisites) {
            map.put(pair[0], map.get(pair[0])+1);
            List<Integer> temp = neighbor.get(pair[1]);
            temp.add(pair[0]);
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=0; i<numCourses; ++i) {
            if(map.get(i) == 0)
                queue.offer(i);
        }
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            List<Integer> temp = neighbor.get(cur);
            for(int i:temp) {
                map.put(i, map.get(i)-1);
                if(map.get(i) == 0)
                    queue.offer(i);
            }
        }
        Iterator<Integer> iterator = map.keySet().iterator();
        while(iterator.hasNext()) {
            int key = iterator.next();
            if(map.get(key) != 0) 
                return false;
        }
        return true;
    }
	
	public static void main(String[] args) {
		CourseSchedule cs = new CourseSchedule();
		int[][] arr = {{1,0}};
		System.out.println(cs.canFinish(2, arr));
	}
}
