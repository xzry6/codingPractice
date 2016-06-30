package acmcoder;

import java.util.Scanner;

public class Jasmin {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNextInt()) {
			int x = s.nextInt();
			int y = s.nextInt();
			int count = 0;
			
			for(int i=x; i<=y; ++i) {
				int num = i;
				int sum = 0;
				while(num != 0) {
					int temp = num%10;
					num = num/10;
					sum += Math.pow(temp,3);
				}
				if(sum == i) {
					if(count != 0) System.out.print(" ");
					System.out.print(sum);
					count ++;
				}
			}
			
			if(count == 0) System.out.print("no");
			System.out.println();
		}
		s.close();
	}
}
