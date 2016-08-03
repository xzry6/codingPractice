package com.codingPractice.app.acmcoder;

import java.util.Scanner;

public class DistanceBetweenTwoPoints {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNextDouble()) {
			double x1 = s.nextDouble();
			double y1 = s.nextDouble();
			double x2 = s.nextDouble();
			double y2 = s.nextDouble();
			double output = Math.sqrt(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2));
			System.out.println(String.format("%.2f", output));
		}
		s.close();
	}
}
