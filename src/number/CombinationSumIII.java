package number;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
	
	private List<List<Integer>> list = new ArrayList<List<Integer>>();
	
	public List<List<Integer>> combinationSum3(int k, int n) {
		recursive(new ArrayList<Integer>(),k,n,0);
		return list;
    }
	
	private void recursive(List<Integer> temp, int k, int n, int l) {
		if(k==1) {
			if(n>l&&n<10) {
				temp.add(n);
				list.add(temp);
			}
			return;
		}
		for(int i=l+1; i<=n&&i<10; ++i) {
			List<Integer> newlist = new ArrayList<Integer>(temp);
			newlist.add(i);
			recursive(newlist,k-1,n-i,i);
		}
	}
	
	public static void main(String[] args) {
		CombinationSumIII a = new CombinationSumIII();
		List<List<Integer>> list = a.combinationSum3(3, 17);
		for(List<Integer> l:list) {
			for(int i:l) 
				System.out.print(i+" ");
			System.out.println();
		}
	}
}
