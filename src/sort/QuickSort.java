package sort;

import java.util.ArrayList;
import java.util.List;

public class QuickSort implements Sort {
	
	@Override
	public void sort(int[] arr) {
		if(arr == null || arr.length == 0) return;
		quickSort(arr, 0, arr.length-1);
	}
	
	private void quickSort(int[] arr, int start, int end) {
		if(start >= end) return;
		int p1 = start;
		int p2 = end;
		int pivot = arr[end];
		while(p1 < p2) {
			while(arr[p1] <= pivot && p1 < p2)
				p1++;
			arr[p2] = arr[p1];
			while(arr[p2] >= pivot && p1 < p2)
				p2--;
			arr[p1] = arr[p2];
		}
		arr[p2] = pivot;
		quickSort(arr, start, p1-1);
		quickSort(arr, p1+1, end);
	}

}
