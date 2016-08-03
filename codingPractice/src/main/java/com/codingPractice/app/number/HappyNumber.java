package com.codingPractice.app.number;

import java.util.HashSet;

public class HappyNumber {
	public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        while(n != 1) {
            int sum = 0;
            while(n != 0) {
                sum += Math.pow(n%10, 2);
                n = n/10;
            }
            System.out.println(sum);
            if(set.contains(sum)) return false;
            set.add(sum);
            n = sum;
        }
        return true;
    }
	
	public static void main(String[] args) {
		HappyNumber hn = new HappyNumber();
		System.out.println(hn.isHappy(7));
	}
}
