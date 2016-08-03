package com.codingPractice.app.number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(candidates == null || candidates.length == 0) return list;
		recursive(list, new ArrayList<Integer>(), -1, candidates, target);
		return list;
    }
	
	private void recursive(List<List<Integer>> list,
							List<Integer> temp, int num,
							int[] candidates, int target) {
		List<Integer> newlist = new ArrayList<Integer>(temp);
		if(num != -1) {
			target = target-candidates[num];
			if(target < 0) 
				return;
			newlist.add(candidates[num]);
			if(target == 0) {
				list.add(newlist);
				return;
			}
		}
		for(int i=num+1; i<candidates.length; ++i) {
			if(i != num+1 && candidates[i] == candidates[i-1]) continue;
			recursive(list, newlist, i, candidates, target);
		}
	}
	
	public static void main(String[] args) {
		CombinationSumII cs2 = new CombinationSumII();
		int[] candidates = {1,1};
		List<List<Integer>> list = cs2.combinationSum2(candidates, 2);
		for(List<Integer> temp:list) {
			for(int i:temp) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
}
