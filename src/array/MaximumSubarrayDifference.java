package array;

import java.util.ArrayList;

public class MaximumSubarrayDifference {
	public static int maxDiffSubArrays(ArrayList<Integer> nums) {
		if(nums == null || nums.size() ==0) return -1;
        int[] leftmax = new int[nums.size()];
        int[] leftmin = new int[nums.size()];
        int tempmax = 0;
        int tempmin = 0;
        int leftsum = 0;
        for(int i=0; i<nums.size(); ++i) {
            leftsum += nums.get(i);
            if(i != 0) {
                leftmax[i] = Math.max(leftmax[i-1], leftsum-tempmin);
                leftmin[i] = Math.min(leftmin[i-1], leftsum-tempmax);
            } else 
                leftmax[i] = leftmin[i] = leftsum;
            tempmax = Math.max(tempmax, leftsum);
            tempmin = Math.min(tempmin, leftsum);
        }
        
        int[] rightmax = new int[nums.size()];
        int[] rightmin = new int[nums.size()];
        tempmax = tempmin = 0;
        int rightsum = 0;
        for(int i=nums.size()-1; i>=0; --i) {
            rightsum += nums.get(i);
            if(i != nums.size()-1) {
                rightmax[i] = Math.max(rightmax[i+1], rightsum-tempmin);
                rightmin[i] = Math.min(rightmax[i+1], rightsum-tempmax);
            } else 
                rightmax[i] = rightmin[i] = rightsum;
            tempmax = Math.max(tempmax, rightsum);
            tempmin = Math.min(tempmin, rightsum);
        }
        
        int globalmax = Integer.MIN_VALUE;
        for(int i=1; i<nums.size(); ++i) {
            int temp = Math.max(Math.abs(rightmax[i]-leftmin[i-1]), 
                        Math.abs(leftmax[i-1]-rightmin[i]));
            globalmax = Math.max(globalmax, temp);
        }
        return globalmax;
    }
	
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(-5);
		list.add(-4);
		System.out.println(maxDiffSubArrays(list));
	}
}
