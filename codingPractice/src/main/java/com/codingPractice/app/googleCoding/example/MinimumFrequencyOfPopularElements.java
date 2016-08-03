package com.codingPractice.app.googleCoding.example;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MinimumFrequencyOfPopularElements {
	public static void main(String[] args) {
		int[] arr = {1, 1, 1, 1, 2, 2, 3, 5, 5, 5};
		System.out.println(getMinimumFrequency(arr));
	}

	private static int getMinimumFrequency(int[] arr) {
		// Deal with null and empty first.
		if(arr == null || arr.length == 0) return Integer.MAX_VALUE;
		// Create a candidate list.
		Set<Integer> set = new HashSet<Integer>();
		int length = arr.length;
		int portion = length/4+1;
		int piece = portion-1;
		while(piece < length) {
			set.add(arr[piece]);
			piece += portion;
		}
		// Binary search on the candidates.
		Iterator<Integer> iterator = set.iterator();
		int min = Integer.MAX_VALUE;
		while(iterator.hasNext()) {
			int num = iterator.next();
			int frequency = getFrequency(arr, num);
			if(frequency > length/4) min = Math.min(min, frequency);
		}
		// Return minimum.
		return min;
	}

	private static int getFrequency(int[] arr, int candidate) {
		int p1 = -1;
		int p2 = -1;

		// Get p1;
		int begin = 0;
		int end = arr.length-1;
		while(begin+1 < end) {
			int mid = (begin+end)/2;
			if(arr[mid] < candidate) begin = mid;
			else end = mid;
		}
		if(arr[begin] == candidate) p1 = begin;
		else p1 = end;

		// Get p2;
		begin = 0;
		end = arr.length-1;
		while(begin+1 < end) {
			int mid = (begin+end)/2;
			if(arr[mid] > candidate) end = mid;
			else begin = mid;
		}
		if(arr[end] == candidate) p2 = end;
		else p2 = begin;

		return p2-p1+1;
	}
}
