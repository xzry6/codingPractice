package array;

import java.util.Arrays;

public class MaximumGap {
	public static int maximumGap(int[] num) {
		if(num.length<2) return 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int n:num) {
        	max = Math.max(n, max);
        	min = Math.min(n, min);
        }
        int gap = (int)Math.ceil((double)(max-min)/(num.length-1));
        int[] bmax = new int[(max-min)/gap+1];
        int[] bmin = new int[(max-min)/gap+1];
        Arrays.fill(bmax, Integer.MIN_VALUE);
        Arrays.fill(bmin, Integer.MAX_VALUE);
        for(int n:num) {
        	int pos = (n-min)/gap;
        	bmax[pos] = Math.max(bmax[pos], n);
        	bmin[pos] = Math.min(bmin[pos], n);
        }
        int count = 0;
        int result = 0;
        for(int n=0; n<(max-min)/gap+1; ++n) {
        	if(bmax[n]==Integer.MIN_VALUE&&bmin[n]==Integer.MAX_VALUE) 
        		continue;
        	result = Math.max(result, bmin[n]-bmax[count]);
        	count = n;
        }
        return result;
    }
	public static void main(String[] args) {
		int[] num = {3,6,9,1};
		System.out.println(maximumGap(num));
	}
}
