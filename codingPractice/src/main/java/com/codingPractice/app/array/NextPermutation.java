package com.codingPractice.app.array;

import java.util.Arrays;

public class NextPermutation {
	public void nextPermutation(int[] nums) {
	    if(nums == null || nums.length < 2) return;
	    int count = 0;
	    for(int i=nums.length-2; i>=0; --i) {
	        if(nums[i] < nums[i+1]) {
	            count = i+1;
	            break;
	        }
	    }
	    int pos = count;
	    if(count != 0) {
	        int min = Integer.MAX_VALUE;
	        for(int i=count; i<nums.length; ++i) {
	            if(nums[i] > nums[count-1]) {
	                min = Math.min(nums[i], min);
	                pos = i;
	            }
	        }
	        int temp = nums[count-1];
	        nums[count-1] = nums[pos];
	        nums[pos] = temp;
	    }
	    partition(nums, count, nums.length-1);
	}
	
	private void partition(int[] nums, int start, int end) {
	    int num = nums[start];
	    int p1 = start;
	    int p2 = end;
	    while(p1 <= p2) {
	        if(nums[p1] < num) {
	            p1++;
	            continue;
	        }
	        if(nums[p2] > num) {
	            p2--;
	            continue;
	        }
	        int temp = nums[p1];
	        nums[p1++] = nums[p2];
	        nums[p2--] = temp;
	    }
	    if(start < p1-1) partition(nums, start, p1-1);
	    if(p1 < end) partition(nums, p1, end);
	}
		
	int partition1(int arr[], int left, int right)
	{
	      int i = left, j = right;
	      int tmp;
	      int pivot = arr[(left + right) / 2];
	     
	      while (i <= j) {
	            while (arr[i] < pivot)
	                  i++;
	            while (arr[j] > pivot)
	                  j--;
	            if (i <= j) {
	                  tmp = arr[i];
	                  arr[i] = arr[j];
	                  arr[j] = tmp;
	                  i++;
	                  j--;
	            }
	      };
	     
	      return i;
	}
	 
	void quickSort(int arr[], int left, int right) {
	      int index = partition1(arr, left, right);
	      System.out.println(index);
	      if (left < index - 1)
	            quickSort(arr, left, index - 1);
	      if (index < right)
	            quickSort(arr, index, right);
	}

	public static void main(String[] args) {
		NextPermutation np = new NextPermutation();
		int[] nums = {2,3,1};
		np.nextPermutation3(nums);
//		np.quickSort(nums, 2, 5);
		System.out.println(Arrays.toString(nums));
	}

	public void nextPermutation3(int[] nums) {
        if(nums == null || nums.length == 0) return;

        // Replace last number first.
        int position = findOneAndUpdate(nums);
        // Sort the array after that position;
        if(nums.length > position+1) {
            Arrays.sort(nums, position+1, nums.length);
        }
    }

	// Return the index of the replaced position.
    // Return nums.length-1 if no position is replaced.
	public int findOneAndUpdate(int[] nums) {
        // First pass find the replaced number.
        int position = nums.length-1;
        for(int i=nums.length-2; i>=0; --i) {
            if(nums[i] < nums[i+1]) {
                position = i;
                break;
            }
        }
        // Second pass find the smallest number which is greater than position number.
        int minPosition = position+1;
        for(int i=position+2; i<nums.length; ++i) {
            if(nums[i] > nums[position] && nums[i] < nums[minPosition]) {
                minPosition = i;
            }
        }
        if(minPosition < nums.length) {
	        int temp = nums[minPosition];
	        nums[minPosition] = nums[position];
	        nums[position] = temp;
        }
        return position;
    }
}
