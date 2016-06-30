package array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        Set<Integer> set = new HashSet<Integer>();

        for(int num:nums) {
            if(set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        Integer[] result = new Integer[2];

        return false;
    }
}
