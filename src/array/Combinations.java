package array;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
		if(k>n) return list;
		for(int i=0; i<n; ++i) {
			recursive(i,k,n,temp,list);
		}
		return list;
	}
	static void recursive(int num, int k, int n, List<Integer> temp, List<List<Integer>> list) {
		temp = new ArrayList<Integer>(temp);
		temp.add(num+1);
		int len = temp.size();
		if(len==k) {
			list.add(temp);
			return;
		}
		for(int i=num+1; i<n; ++i) {
			recursive(i, k, n, temp, list);
		}
	}
	public static void main(String[] args) {
		List<List<Integer>> list = combine(5,3);
		for(int i=0; i<list.size(); ++i) {
			for(int j=0; j<list.get(i).size(); ++j) {
				System.out.print(list.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}
}
