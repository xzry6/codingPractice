package com.codingPractice.app.googleCoding.example;

import java.util.ArrayList;
import java.util.List;

public class SumNI {
	/*
	 * n^i = (n^0 + n^1 + ... + n^(i - 1)) * (n - 1) + 1
	 *     = n^1 + ... + n^i - (n^0 + ... + n^(i - 1)) + 1
	 *     = n^i - n^0 + n^0
	 *     = n^i
	 *
	 * 11 = 8 + 2 + 1
	 */
	private int sumOfNPowerI(int n, int i) {
		// Deal with edge cases first.
		if(i < 0) {
			return - 1;
		}
		// Split i, return a list of the end.
		List<Integer> list = split(i);
		// Divide and conquer and return the sum.
		int sum = 0;
		for(int l = 1; l < list.size(); ++ l) {
			int pre = list.get(l - 1);
			int cur = list.get(l);
			int multiplier = sum * (n - 1) + 1;
			if(l == 1)
			sum += multiplier * divideConquer(n, cur - pre);
			else
				sum += multiplier * divideConquer(n, cur - pre - 1);
		}

		return sum == 0 ? 1 : sum;
	}

	/**
	 * Calculate 2^a.
	 * 
	 * @param n {int} - input number;
	 * @param i {int} - i is 2^a;
	 * @return - sum of 2^a;
	 */
	private int divideConquer(int n, int i) {
		if(i == 0) {
			return 1;
		}

		if(i % 2 == 1) {
			int preSum = divideConquer(n, i / 2);
			return (preSum * (n - 1) + 2) * preSum;
		} else {
			int preSum = divideConquer(n, i - 1);
			return (preSum * (n - 1) + 1) + preSum;
		}
	}

	/**
	 * Given a number, get a list of the sum by the factor 2;
	 * e.x. i = 11, then list<Integer> 
	 *      will be {8(2^3), 10(2^3 + 2^1), 11(2^3 + 2^1 + 2^0)};
	 * 
	 * @param i {int} - input factor;
	 * @return - a list of the sum by the factor n;
	 */
	private List<Integer> split(int i) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		int sum = 0;
		int num = 1;
		while(sum != i) {
			while(sum + num * 2 <= i) {
				num = num * 2;
			}
			sum += num;
			num = 1;
			list.add(sum);
		}
		return list;
	}

	public static void main(String[] args) {
		SumNI ni = new SumNI();
		System.out.println(ni.sumOfNPowerI(2, 7));
	}
}
