package com.codingPractice.app.sort;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Sort s1 = new MergeSort();
		Sort s2 = new QuickSort();
		//int[] arr = {0,5,2,3,1,4,7,9,8};
		int[] arr = {2,0,0,1,2,0,2};
		s2.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
