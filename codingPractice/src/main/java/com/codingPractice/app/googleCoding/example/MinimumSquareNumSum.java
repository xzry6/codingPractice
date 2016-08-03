package com.codingPractice.app.googleCoding.example;

import java.util.ArrayList;
import java.util.List;

public class MinimumSquareNumSum {

	public static void main(String[] args) {
		MinimumSquareNumSum msns = new MinimumSquareNumSum();
		System.out.println(msns.minCountDP(6));
	}

	public int minCount(int number) {
		int min = Integer.MAX_VALUE;
		for(int i = number; i >= 1; -- i) {
			if(i * i > number) {
				continue;
			}
			if(i * i == number) {
				return 1;
			}
			min = Math.min(min, minCount(number - i * i) + 1);
		}
		return min;
	}

	public int minCountDP(int number) {
		int[] numbers = new int[number + 1];
		numbers[0] = 0;
		for(int i = 1; i < number + 1; ++ i) {
			numbers[i] = i;
			for(int j = 0; j <= i; ++ j) {
				if(j * j > i) {
					break;
				}
				numbers[i] = Math.min(numbers[i], 1 + numbers[i - j * j]);
			}
		}
		return numbers[number];
	}
}
