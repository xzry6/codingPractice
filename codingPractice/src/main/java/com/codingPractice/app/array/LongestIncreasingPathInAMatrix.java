package com.codingPractice.app.array;

/**
 * Given an integer matrix, find the length of the longest increasing path.
 * From each cell, you can either move to four directions: left, right, up or down.
 * You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
 * 
 * Example 1:
 * 
 * nums = [
 *  [9,9,4],
 *  [6,6,8],
 *  [2,1,1]
 * ]
 * Return 4
 * The longest increasing path is [1, 2, 6, 9].
 * 
 * Example 2:
 * 
 * nums = [
 *  [3,4,5],
 *  [3,2,6],
 *  [2,2,1]
 * ]
 * Return 4
 * The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 * 
 * @author Sean
 *
 */
public class LongestIncreasingPathInAMatrix {
	public static void main(String[] args) {
		LongestIncreasingPathInAMatrix l = new LongestIncreasingPathInAMatrix();
		int[][] matrix = {{3, 4, 5}, {3, 2, 6}, {2, 2, 1}};
		System.out.println(l.longestIncreasingPath(matrix));
	}

	public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int max = 1;
        for(int i = 0; i < matrix.length; ++ i) {
            for(int j = 0; j < matrix[i].length; ++ j) {
                int tmp = recursive(matrix, i, j);
                max = Math.max(max, tmp);
            }
        }

        return max;
    }

    private int recursive(int[][] matrix, int i, int j) {
        int left = 1;
        int right = 1;
        int top = 1;
        int bottom = 1;
        if(j > 0 && matrix[i][j - 1] > matrix[i][j])
            left = recursive(matrix, i, j - 1) + 1;
        if(j < matrix[0].length - 1 && matrix[i][j + 1] > matrix[i][j])
            right = recursive(matrix, i, j + 1) + 1;
        if(i > 0 && matrix[i - 1][j] > matrix[i][j])
            top = recursive(matrix, i - 1, j) + 1;
        if(i < matrix.length - 1 && matrix[i + 1][j] > matrix[i][j])
            bottom = recursive(matrix, i + 1, j) + 1;
        return Math.max(Math.max(left, right), Math.max(top, bottom));
    }
}
