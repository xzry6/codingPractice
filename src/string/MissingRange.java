package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array 
 * where the range of elements are [lower, upper] inclusive, 
 * return its missing ranges.
 * 
 * For example
 * given [0, 1, 3, 50, 75], 
 * lower = 0
 * upper = 99
 * return ["2", "4->49", "51->74", "76->99"].
 * 
 * @author Sean
 *
 */
public class MissingRange {
	// {0, 1, 3, 50, 75}, 0, 99
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        // New list.
        List<String> list = new ArrayList<String>();

        // Deal with edge cases first.
        if(lower > upper) return list;

        // Variables.
        int begin = lower;

        // Loop.
        for(int i = 0; i < nums.length; ++ i) {
            if(nums[i] < lower) continue;
            if(nums[i] > upper) break;
            if(nums[i] != begin) {
                if(nums[i] - 1 == begin) list.add(Integer.toString(begin));
                else list.add(Integer.toString(begin) + "->" + Integer.toString(nums[i] - 1));
            }
            begin = nums[i] + 1;
        }

        if(begin < upper) list.add(Integer.toString(begin) + "->" + Integer.toString(upper));
        if(begin == upper) list.add(Integer.toString(begin));

        // Return.
        return list;
    }
}
