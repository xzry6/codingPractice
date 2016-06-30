package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
	public static List<List<Integer>> subsets(int[] S) {
		Arrays.sort(S);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        list.add(temp);
		for(int i=0; i<S.length; ++i) {
			int len = list.size();
        	for(int j=0; j<len; ++j) {
        		temp = new ArrayList<Integer>(list.get(j));
        		temp.add(S[i]);
        		list.add(temp);
        	}
        }
		return list;
    }
	public static void main(String[] args) {
		int[] S = {1,2,3};
		List<List<Integer>> list = subsets(S);
		for(int i=0; i<list.size(); ++i) {
			for(int j=0; j<list.get(i).size(); ++j) {
				System.out.print(list.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}
}
