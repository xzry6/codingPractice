package dataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {

	public static void main(String[] args) {
		int[] nums = {1,2,3,9};
		List<Integer> list = largestDivisibleSubset(nums);
		for(int i:list) {
			System.out.println(i);
		}
	}

	public static List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) {
            return list;
        }
        // Sort.
        Arrays.sort(nums);
        // Double loop.
        int[] count = new int[nums.length];
        int[] indexes = new int[nums.length];
        int max = 1;
        int maxIndex = 0; 
        Arrays.fill(indexes, -1);
        for(int i = 0; i < nums.length; ++ i) {
        		count[i] = 1;
            for(int j = 0; j < i; ++ j) {
            		if(nums[i] % nums[j] == 0 && count[j] + 1 > count[i]) {
            			count[i] = count[j] + 1;
            			indexes[i] = j;
            			if(count[i] > max) {
            				maxIndex = i;
            				max = count[i];
            			}
            		}
            }
        }
        while(maxIndex != -1) {
        		list.add(0, nums[maxIndex]);
        		maxIndex = indexes[maxIndex];
        }
        return list;
    }
}
