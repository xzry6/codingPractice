package array;

import java.util.Arrays;

public class Candy {
	public static int candy(int[] ratings) {
		int[] count = new int[ratings.length];
		Arrays.fill(count, 1);
		for(int i=1; i<count.length; ++i) {
			if(ratings[i]>ratings[i-1]) count[i] = count[i-1]+1;
		}
		int total = count[count.length-1];
		int acc = 1;
		for(int i=count.length-2; i>-1; --i) {
			if(ratings[i]>ratings[i+1]) acc++;
			else acc = 1;
			count[i] = Math.max(count[i], acc);
			total += count[i];
		}
		return total;
    }
	public static void main(String[] args) {
		int[] a = {1,2};
		System.out.println(candy(a));
	}
}
