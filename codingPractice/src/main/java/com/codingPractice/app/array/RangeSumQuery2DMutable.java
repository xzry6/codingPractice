package com.codingPractice.app.array;

/**
 * Given a 2D matrix matrix,
 * find the sum of the elements inside the rectangle
 * defined by its upper left corner (row1, col1) 
 * and lower right corner (row2, col2).
 * 
 * Example:
 * Given matrix = [
 *  [3, 0, 1, 4, 2],
 *  [5, 6, 3, 2, 1],
 *  [1, 2, 0, 1, 5],
 *  [4, 1, 0, 1, 7],
 *  [1, 0, 3, 0, 5]
 * ]
 * 
 * sumRegion(2, 1, 4, 3) -> 8
 * update(3, 2, 2)
 * sumRegion(2, 1, 4, 3) -> 10
 * 
 * @author Sean
 *
 */
public class RangeSumQuery2DMutable {
	public static void main(String[] args) {
		int[][] matrix = {{2, 4}, {-3, 5}};
		RangeSumQuery2DMutable r = new RangeSumQuery2DMutable(matrix);
		r.update(0, 1, 3);
		r.update(1, 1, -3);
		r.update(0, 1, 1);
		System.out.println(r.sumRegion(0, 0, 1, 1));
		
	}

	private int[][] matrix;
    private int[][] bit;
    private int rows;
    private int cols;

    public RangeSumQuery2DMutable(int[][] matrix) {
        this.rows = matrix.length;
        if(this.rows == 0) return;

        this.cols = matrix[0].length;
        this.matrix = new int[this.rows][this.cols];
        this.bit = new int[this.rows + 1][this.cols + 1];
        for(int i = 0; i < this.rows; ++ i)
            for(int j = 0; j < this.cols; ++ j)
                update(i, j, matrix[i][j]);
    }
    
    public void update(int row, int col, int val) {
        if(this.rows == 0 || this.cols == 0) return;

        int increment = val - this.matrix[row][col];
        this.matrix[row][col] = val;
        for(int i = row + 1; i <= this.rows; i += (i & (-i)))
            for(int j = col + 1; j <= this.cols; j += (j & (-j)))
                this.bit[i][j] += increment;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum(row2 + 1, col2 + 1)
             + sum(row1, col1)
             - sum(row2 + 1, col1)
             - sum(row1, col2 + 1);
    }

    private int sum(int row, int col) {
        int sum = 0;
        for(int i = row; i > 0; i -= (i & (-i)))
            for(int j = col; j > 0; j -= (j & (-j)))
                sum += this.bit[i][j];
        return sum;
    }
}
