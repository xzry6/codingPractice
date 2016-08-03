package com.codingPractice.app.sort;

public class MergeSort implements Sort{

	@Override
	public void sort(int[] arr) {
		if(arr == null || arr.length == 0) return;
		int[] target = new int[arr.length];
		mergeSort(arr, target, 0, arr.length-1);
	}
	
	private void mergeSort(int[] arr, int[] target, int start, int end) {
		if(start >= end) return;
		int mid = start+(end-start)/2;
		mergeSort(arr, target, start, mid);
		mergeSort(arr, target, mid+1, end);
		int p = start;
		int p1 = start;
		int p2 = mid+1;
		while(p1 <= mid && p2 <= end)
			target[p++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		while(p1 <= mid)
			target[p++] = arr[p1++];
		while(p2 <= end)
			target[p++] = arr[p2++];
		for(int i=start; i<end; ++i)
			arr[i] = target[i];
	}
	
}
