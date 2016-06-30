package array;

import java.util.ArrayList;
import java.util.List;

public class SummaryRange {
	public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<String>();
        if(nums == null || nums.length == 0) return list;
        int pre = nums[0];
        int start = pre;
        for(int i=1; i<nums.length; ++i) {
            int cur = nums[i];
            if(cur > pre+1) {
                String temp = buildStr(start, pre);
                list.add(temp);
                start = cur;
            }
            pre = cur;
        }
        String temp = buildStr(start, pre);
        list.add(temp);
        return list;
    }
    
    private String buildStr(int start, int end) {
        StringBuilder sb = new StringBuilder();
        if(start > end) return sb.toString();
        sb.append(start);
        if(start == end) return sb.toString();
        sb.append("->").append(end);
        return sb.toString();
    }
    
    public static void main(String[] args) {
    		SummaryRange sr = new SummaryRange();
    		int[] nums = {0, 1};
    		System.out.println(sr.summaryRanges(nums));
    }
}
