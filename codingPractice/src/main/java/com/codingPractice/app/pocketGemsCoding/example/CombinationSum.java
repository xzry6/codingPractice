package com.codingPractice.app.pocketGemsCoding.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	public static void main(String[] args) {
		int[] candidates = {2, 3, 5};
		int target = 7;
		List<List<Integer>> list = combinationSum(candidates, target);
		for(List<Integer> temp:list) {
			for(int i:temp) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	 public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        // Deal with null and empty cases first.
        if(candidates == null || candidates.length == 0) return list;
        // Sort the array.
        Arrays.sort(candidates);
        // Recursive.
        recursive(list, new ArrayList<Integer>(), 0, 0, candidates, target);
        // Return.
	        return list;
    }

    private static void recursive(List<List<Integer>> list, List<Integer> temp, int sum, int position, int[] candidates, int target) {
        if(sum > target) {
            return;
        }
        if(sum == target) {
            list.add(new ArrayList<Integer>(temp));
            return;
        }

        for(int i = position; i < candidates.length; ++ i) {
            if(i != position && candidates[i] == candidates[i - 1]) {
                continue;
            }
            int cur = candidates[i];
            temp.add(cur);
            recursive(list, temp, sum + cur, i, candidates, target);
            temp.remove(temp.size() - 1);
        }
    }
}
