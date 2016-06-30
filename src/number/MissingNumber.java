package number;

public class MissingNumber {
	public int missingNumber(int[] nums) {
        int temp = 0;
        for(int i=0; i<nums.length; ++i)
        	temp = temp^nums[i]^(i+1);
        return temp;
    }
}
