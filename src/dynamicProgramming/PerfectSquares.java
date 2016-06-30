package dynamicProgramming;

import java.util.Arrays;

public class PerfectSquares {
	public int numSquares(int n) {
		int[] array = new int[n+1];
		Arrays.fill(array,Integer.MAX_VALUE);
		array[0] = 0;
		for(int i=0; i<n; ++i)
			for(int j=1; i+j*j<=n; ++j)
				array[i+j*j] = Math.min(array[i]+1,array[i+j*j]);
		return array[n];
	}
}
