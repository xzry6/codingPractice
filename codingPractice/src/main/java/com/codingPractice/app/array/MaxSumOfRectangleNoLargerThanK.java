package com.codingPractice.app.array;

import java.util.TreeSet;

public class MaxSumOfRectangleNoLargerThanK {

	public static void main(String[] args) {
		int[][] matrix = {{5,-4,-3,4}, {-3,-4,4,5}, {5,1,5,-4}};
		System.out.println(maxSumSubmatrix(matrix, -1));
	}

	public static int maxSumSubmatrix(int[][] matrix, int k) {
        // Deal with empty cases first.
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        // Variables.
        int[][] sums = new int[matrix.length][matrix[0].length];
        // Loop.
        for(int i = 0; i < matrix.length; ++ i) {
            sums[i][0] = i == 0 ? matrix[0][0] : sums[i - 1][0] + matrix[i][0];
            for(int j = 1; j < matrix[i].length; ++ j) {
                sums[i][j] = sums[i][j - 1] + matrix[i][j];
            		if(i > 0) sums[i][j] += sums[i - 1][j] - sums[i - 1][j - 1];
            }
        }

        int max = Integer.MIN_VALUE;
        for(int p1 = 0; p1 < matrix.length; ++ p1) {
            for(int p2 = p1; p2 < matrix.length; ++ p2) {
                TreeSet<Integer> set = new TreeSet<Integer>();
                set.add(0);
                for(int j = 0; j < matrix[p2].length; ++ j) {
                    int area = sums[p2][j];
                    if(p1 > 0) area -= sums[p1 - 1][j];
                    Integer ceiling = set.ceiling(area - k);
                    if(ceiling != null) max = Math.max(max, area - ceiling);
                    set.add(area);
                }
            }
        }
        // Return.
        return max;
    }
}
