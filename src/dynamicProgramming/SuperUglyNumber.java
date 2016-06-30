package dynamicProgramming;

import java.util.Arrays;

public class SuperUglyNumber {
	 public int nthSuperUglyNumber(int n, int[] primes) {
	        if(primes == null || primes.length == 0) return 1;
	        int[] arr = new int[n];
	        arr[0] = 1;
	        int[] index = new int[primes.length];
	        for(int i=1; i<n; ++i) {
	            arr[i] = Integer.MAX_VALUE;
	            int pos = 0;
	            for(int j=0; j<primes.length; ++j) {
	                if(primes[j]*arr[index[j]] < arr[i]) {
	                    arr[i] = primes[j]*arr[index[j]];
	                    pos = j;
	                }
	            }
	            index[pos]++;
	        }
	        System.out.println(Arrays.toString(arr));
	        return arr[n-1];
	   }
	   public static void main(String[] args) {
		   int[] arr = {2,7,13,19};
		   SuperUglyNumber sun = new SuperUglyNumber();
		   System.out.println(sun.nthSuperUglyNumber(12, arr));
	   }
}
