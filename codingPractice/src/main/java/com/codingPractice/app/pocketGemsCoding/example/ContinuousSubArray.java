package com.codingPractice.app.pocketGemsCoding.example;

import java.util.ArrayList;

public class ContinuousSubArray {
	public static void main(String[] args) {
		int[] A = {10, -3, -4, 7, 6, 5, -4, -1};
		ArrayList<Integer> list = continuousSubarraySumII(A);
		for(int num:list) {
			System.out.println(num);
		}
	}
	public static ArrayList<Integer> continuousSubarraySumII(int[] A) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        // Deal with null and empty cases first.
        if(A == null || A.length == 0) {
            return list;
        }
        list.add(0);
        list.add(0);
        // Variables.
        int max = A[0];
        int local = A[0];
        int begin = 0;

        // While Loop.
        	for(int i = 1; i < A.length * 2; ++i) {
            int num = A[i % A.length];
            // Break.
            if(i - begin >= A.length) {
            		break;
            }

            if(num > local + num) {
                begin = i;
                local = num;
            } else {
                local = num + local;
            }
            if(local > max) {
                list.set(0, begin);
                list.set(1, i % A.length);
                max = local;
            }
        }
        	System.out.println(max);
        // Return.
        return list;
    }
}
