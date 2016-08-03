package com.codingPractice.app.pocketGemsCoding.example;

import java.util.PriorityQueue;
import java.util.Queue;

public class LinkStickers {
	public int getMinCost(int[] lengths) {
		if(lengths == null || lengths.length == 0) {
			return 0;
		}
		Queue<Integer> queue = new PriorityQueue<Integer>();
		for(int length:lengths) {
			queue.offer(length);
		}
		int cost = 0;
		while(!queue.isEmpty()) {
			int shortest = queue.poll();
			if(queue.isEmpty()) {
				break;
			}
			int secondShortest = queue.poll();
			int newLength = shortest + secondShortest;
			queue.offer(newLength);
			cost += newLength;
		}
		return cost;
	}
}
