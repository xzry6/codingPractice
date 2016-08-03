package com.codingPractice.app.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null) return null;
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        recursive(list, new ArrayList<Integer>(), candidates, 0, target);
        return list;
    }
	
	private void recursive(List<List<Integer>> list, 
							List<Integer> tempList, 
							int[] candidates, int pos, int target) {
		if(target == 0) {
			list.add(new ArrayList<Integer>(tempList));
			return;
		}
		for(int i = pos; i < candidates.length; ++i) {
			if(candidates[i] > target) break;
			else {
				List<Integer> newList = new ArrayList<Integer>(tempList);
				newList.add(candidates[i]);
				recursive(list, newList, candidates, i, target-candidates[i]);
			}
		}
	}
}
