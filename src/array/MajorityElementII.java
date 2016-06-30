package array;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
	public List<Integer> majorityElement(int[] nums) {
        int c1 = 0, c2 = 0;
        int n1 = 0, n2 = 1;
        for(int n:nums) {
        		if(n==n1) 
        			c1++;
        		else if(n==n2) 
        			c2++;
        		else if(c1==0) {
        			n1 = n;
        			c1 = 1;
        		}
        		else if(c2==0) {
        			n2 = n;
        			c2 = 1;
        		}
        		else {
        			c1--;
        			c2--;
        		}
        }
        c1 = 0;
        c2 = 0;
        for(int n:nums) {
        		if(n==n1) c1++;
        		else if(n==n2) c2++;
        }
        List<Integer> list = new ArrayList<Integer>();
        if(c1>nums.length/3) list.add(n1);
        if(c2>nums.length/3) list.add(n2);
        return list;
    }
	
	public static void main(String[] args) {
		int[] array = {1,2};
		MajorityElementII meii = new MajorityElementII();
		List<Integer> list = meii.majorityElement(array);
		for(int i:list)
			System.out.println(i);
	}
}
