package com.codingPractice.app.acmcoder;

import java.util.Scanner;

public class SumOfArray {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNextInt()) {
			int n = s.nextInt();
			int m = s.nextInt();
			double sum = 0;
			double temp = n;
			for(int i=0; i<m; ++i) {
				sum += temp;
				temp = Math.sqrt(temp);
			}
			System.out.println(sum);
		}
		s.close();
	}
}
