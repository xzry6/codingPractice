package com.codingPractice.app.array;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
        if(nums == null) return null;
        List<List<Integer>> list = new ArrayList<List<Integer>>();
		recursive(list, new ArrayList<Integer>(), nums);
		return list;
    }
	
	private void recursive(List<List<Integer>> list,
						   List<Integer> tempList,
						   int[] nums) {
		if(tempList.size() == nums.length) {
			list.add(tempList);
			return;
		}
		for(int n:nums) {
			if(!tempList.contains(n)) {
				tempList.add(n);
				recursive(list, tempList, nums);
				tempList.remove(tempList.size()-1);
			}
		}
	}
}
