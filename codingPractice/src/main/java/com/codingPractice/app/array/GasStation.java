package com.codingPractice.app.array;

public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if(gas.length==0||cost.length!=gas.length) return -1;
		int start = 0;
        int point = start;
        int total = 0;
        while(gas[point]!=-1) {
        	int current = 0;
        	if(total>=0) {
            	current = gas[point]-cost[point];
        		gas[point] = -1;
        		point++;
        		if(point==cost.length) point = 0;
        	} else {
        		if(start==0) start = cost.length;
        		start--;
        		current = gas[start]-cost[start];
        		gas[start] = -1;
        	}
        	total += current;
        }
        if(total>=0) return start;
        return -1;
    }
}
