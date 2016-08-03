package com.codingPractice.app.pocketGemsCoding;

import java.util.Scanner;

public class ScannerTest {

	// Test scanner functionality
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please input from here: ");
		while(true) {
			String line = scanner.nextLine();
			if(line.equals("quit")) {
				break;
			}
			System.out.println(">>> "+line);
		}
	}
}
