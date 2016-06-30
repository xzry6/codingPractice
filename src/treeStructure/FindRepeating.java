package treeStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindRepeating {
	public List<Integer> find(int[] arr) {
		List<Integer> list = new ArrayList<Integer>();
		if(arr == null || arr.length == 0 ) return list;
		for(int i=0; i<arr.length; ++i) {
			if(arr[i] > arr.length) continue;
			if(arr[i]-1 == i) continue;
			int temp = arr[arr[i]-1];
			arr[arr[i]-1] = arr[i];
			arr[i--] = temp;
		}

		for(int i=0; i<arr.length; ++i) {
			if(arr[i]-1 != i) {
				list.add(i+1);
				list.add(arr[i]);
				break;
			}
		}

		return list;
	}

	public static void main(String[] args) {
		int[] arr = {5,3,6,4,2};
		FindRepeating fr = new FindRepeating();
		System.out.println(Arrays.toString(fr.find(arr).toArray()));
	}
}
