package com.codingPractice.app.googleCoding.example;

public class WallAndFlower {

	public static void main(String[] args) {
		char[][] matrix = {
			    {'f', 'x', 'x', 'w', 'f'},
                {'f', 'f', 'x' ,'x' ,'x'},
                {'x', 'x', 'f', 'w', 'f'},
                {'f', 'f', 'x', 'w', 'x'}
        };
		System.out.println(maxFlowers(matrix));
	}

	public static int maxFlowers(char[][] matrix) {
		// Deal with empty and null first.
		if(matrix == null || matrix.length == 0) {
			return 0;
		}
		// Matrix.
		int[][] map = new int[matrix.length][matrix[0].length];
		// Four loops.
		for(int i = 0; i < map.length; ++ i) {
			int left = map[i][0] == 'f' ? 1 : 0;
			int right = map[i][map[i].length - 1] == 'f' ? 1 : 0;
			for(int j = 1; j < map[i].length; ++ j) {
				if(matrix[i][j] == 'w') {
					left = 0;
				} else if(matrix[i][j] == 'f') {
					map[i][j] += (left ++);
				} else {
					map[i][j] += left;
				}
				if(matrix[i][map[i].length - j - 1] == 'w') {
					right = 0;
				} else if(matrix[i][map[i].length - j - 1] == 'f') {
					map[i][j] += (right ++);
				} else {
					map[i][j] += right;
				}
			}
		}

		for(int j = 0; j < map[0].length; ++ j) {
			int top = matrix[0][j] == 'f' ? 1 : 0;
			int bottom = matrix[map.length - 1][j] == 'f' ? 1 : 0;
			for(int i = 1; i < map.length; ++ i) {
				if(matrix[i][j] == 'w') {
					top = 0;
					map[i][j] = 0;
				} else if(matrix[i][j] == 'f'){
					map[i][j] += (top ++);
				} else {
					map[i][j] += top;
				}
				if(matrix[map.length - i - 1][j] == 'w') {
					bottom = 0;
					map[map.length - i - 1][j] = 0;
				} else if(matrix[map.length - i - 1][j] == 'f') {
					map[map.length - i - 1][j] += (bottom ++);
				} else {
					map[map.length - i - 1][j] += bottom;
				}
			}
		}
		// Find and Return.
		int max = 0;
		for(int i = 0; i < map.length; ++ i) {
			for(int j = 0; j < map[i].length; ++ j) {
				int temp = map[i][j] == 'f' ? map[i][j] + 1 : map[i][j];
				max = Math.max(temp, max);
			}
		}
		return max;
	}
}
