package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
	public static int minimumTotal(List<List<Integer>> triangle) {
        int[] val = {triangle.get(0).get(0)};
		int[] newval = total(triangle,val);
		int min = 10000;
		for(int i=0; i<newval.length; ++i){
			if(newval[i]<min) min = newval[i];
		}
		return min;
    }
	static int[] total(List<List<Integer>> triangle, int[] val){
		int row = val.length;
		if(row==triangle.size()) return val;
		int[] newval = new int[row+1];
		newval[0] = triangle.get(row).get(0)+val[0];
		newval[row] = triangle.get(row).get(row)+val[row-1];
		for(int i=1; i<row; ++i){
			newval[i] = triangle.get(row).get(i);
			newval[i] += Math.min(val[i-1],val[i]);
		}
		return total(triangle,newval);
		/*if(row==triangle.size()-1) return val;
		int min = Math.min(triangle.get(row+1).get(col), triangle.get(row+1).get(col+1));
		return total(triangle,row+1,triangle.get(row+1).indexOf(min),val+min);*/
	}
	public static int minimumTotal1(List<List<Integer>> triangle) {
		int[] total = new int[triangle.size()+1];
		for(int i=triangle.size()-1; i>-1; --i){
			for(int j=0; j<i+1; ++j){
				total[j] = triangle.get(i).get(j)+Math.min(total[j], total[j+1]);
			}
		}
		return total[0];
    }
	public static void main(String[] args){
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		List<Integer> temp1 = new ArrayList<Integer>(); temp1.add(-1);
		List<Integer> temp2 = new ArrayList<Integer>(); temp2.add(2); temp2.add(3);
		List<Integer> temp3 = new ArrayList<Integer>(); temp3.add(1); temp3.add(-1); temp3.add(-3);
		triangle.add(temp1); triangle.add(temp2); triangle.add(temp3);
		System.out.println(minimumTotal(triangle));
		System.out.println(minimumTotal1(triangle));
	}
}
