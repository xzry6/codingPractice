package number;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
	public static List<Integer> grayCode(int n) {
         List<Integer> list = new ArrayList<Integer>();
         recursive(n,0,list);
         return list;
    }
	static void recursive(int n, int num, List<Integer> list) {
		if(list.contains(num)) return;
		list.add(num);
		int mask = 1;
		for(int i=0; i<n; ++i) {
			int temp = num|mask;
			recursive(n,temp,list);
			mask<<=1;
		}
	}
	public static List<Integer> grayCode2(int n) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        int mask = 1;
        for(int i=0; i<n; ++i) {
        	for(int j=list.size()-1; j>=0; --j) {
        		list.add(list.get(j)|mask);
        	}
        	mask<<=1;
        }
        return list;
   }
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list = grayCode2(3);
		for(int j=0; j<list.size(); ++j) {
			System.out.println(list.get(j));
		}
	}
}
