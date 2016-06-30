package array;

import java.util.HashMap;


public class MajorityElement {
	public static int majorityElement(int[] num) {
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i:num) {
        	if(hash.containsKey(i)) hash.put(i, hash.get(i)+1);
        	else hash.put(i,1);
        }
        for(int i:hash.keySet()) {
        	if(hash.get(i)>num.length/2)
        		return i;
        }
        return -1;
    }
	public static void main(String[] args) {
		int[] a = {1,1,3,2,1};
		System.out.println(majorityElement(a));
	}
}
