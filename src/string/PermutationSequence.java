package string;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
	public static String getPermutation(int n, int k) {
		StringBuilder s = new StringBuilder();
        int total = 1;
		List<Integer> list = new ArrayList<Integer>();
        for(int i=1; i<=n; ++i) {
        	list.add(i);
        	total*=i;
        }
        if(n==0||k>total) return new String();
        int factor = n;
    	k = k-1;
        while(factor!=0) {
        	total/=factor--;
        	int a = k/total;
        	int b = k%total;
        	k = b;
        	s.append(list.remove(a));
        }
        return s.toString();
    }
	public static void main(String[] args){
		System.out.println(getPermutation(4,6));
		
		
		
	}
}
