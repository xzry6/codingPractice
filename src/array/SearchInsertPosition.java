package array;

public class SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
        if(nums == null) return 0;
        int start = 0;
        int end = nums.length-1;
        while(start+1 < end) {
        		int mid = start+(end-start)/2;
        		if(nums[mid] >= target) end = mid;
        		else start = mid;
        }
        if(nums[end] < target) return end+1;
        if(nums[start] < target) return start+1;
        return 0;
    }
}
