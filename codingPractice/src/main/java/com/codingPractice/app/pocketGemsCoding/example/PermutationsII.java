package com.codingPractice.app.pocketGemsCoding.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
	public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if(nums == null || nums.size() == 0) return list;
        int[] num = new int[nums.size()];
        for(int i=0; i<nums.size(); ++i)
            num[i] = nums.get(i);
        Arrays.sort(num);
        
        recursive(list, new ArrayList<Integer>(), num, new boolean[nums.size()]);
        return list;
    }
    
    private void recursive(ArrayList<ArrayList<Integer>> list,
                            ArrayList<Integer> temp, int[] num,
                            boolean[] bool) {
        if(temp.size() == num.length) {
            list.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i=0; i<num.length; ++i) {
            if(bool[i] || (i != 0 && !bool[i-1] && num[i] == num[i-1])) continue;
            bool[i] = true;
            temp.add(num[i]);
            recursive(list, temp, num, bool);
            bool[i] = false;
            temp.remove(temp.size()-1);
        }
        
    }
 public static void main(String[] args) {
	 ArrayList<Integer> ll = new ArrayList<Integer>();
	 ll.add(1);
	 ll.add(2);
	 ll.add(2);
	 PermutationsII p2 = new PermutationsII();
	 ArrayList<ArrayList<Integer>> list = p2.permuteUnique(ll);
	 for(ArrayList<Integer> temp:list) {
		 for(int t:temp)
			 System.out.print(t+" ");
		 System.out.println();
	 }
 }
}
