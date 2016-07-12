package number;

/**
 * Given a positive integer n,
 * break it into the sum of at least two positive integers 
 * and maximize the product of those integers. 
 * Return the maximum product you can get.
 * 
 * For example, given n = 2, return 1 (2 = 1 + 1); 
 * 			    given n = 10, return 36 (10 = 3 + 3 + 4).
 * 
 * Note: You may assume that n is not less than 2 and not larger than 58.
 * @author Sean
 *
 */
public class IntegerBreak {
	public static void main(String[] args) {
		IntegerBreak ib = new IntegerBreak();
		System.out.println(ib.integerBreak(8));
		// 2 * 1
		// 3 / 2 = 1, 3 % 2 = 1; 2 * 1
		// 4 / 3, 1 * 1 * 2
		// 4 / 2 = 2, 4 % 2 = 0; 2 * 2
		// 6 / 2 = 3, 3^2
	}
	public int integerBreak(int n) {
        // Deal with edge cases first.
		if(n <= 0) return 0;
		// For loop O(57).
		int max = 0;
		for(int i = 2; i <= 58; ++ i) {
			if(i > n) break;
			max = Math.max(max, calculate(n, i));
		}
		// Return.
		return max;
    }

	/*
	 * Given a number and pieces, 
	 * split the number into directed pieces
	 * and return the maximum multiplication.
	 */
	private int calculate(int number, int pieces) {
		int split = number / pieces;
		int plusOne = number - split * pieces;
		return (int) Math.pow(split + 1, plusOne) 
			 * (int) Math.pow(split, pieces - plusOne);
	}
	/**
	 * x^(n/x)
	 * = (n/x) * x^(n/x - 1) + x^(n/x) * ln(x) * n * -1 * x^(-2)
	 * = n * x^(n/x - 2) - n * x^(n/x - 2) * ln(x)
	 * = n * x^(n/x - 2) * (1 - ln(x))
	 * > 0 when (0 < x < e)
	 * 
	 * x = 2 || x = 3 may have the greatest value
	 */
}
