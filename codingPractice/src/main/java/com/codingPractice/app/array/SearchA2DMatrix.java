package com.codingPractice.app.array;

public class SearchA2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0) return false;
        int start = 0;
        int end = matrix.length;
        do {
        	int mid = (start+end)/2;
        	if(matrix[mid][0]==target) return true;
        	if(matrix[mid][0]>target) end = mid;
        	else start = mid;
        } while(end-start>1);
        int begin = 0;
        end = matrix[0].length;
        do {
        	int mid = (begin+end)/2;
        	if(matrix[start][mid]==target) return true;
        	if(matrix[start][mid]>target) end = mid;
        	else begin = mid;
        } while(end-begin>1);
        if(matrix[start][begin]==target) return true;
		return false;
    }
}
