package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns),
 * return all elements of the matrix in spiral order.
 * 
 * For example,
 * Given the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 
 * You should return [1,2,3,6,9,8,7,4,5].
 * 
 * @author Sean
 *
 */

/*
 *  1  2  3
 *  4  5  6
 *  7  8  9
 *  10 11 12
 */
public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
        // Edge Cases.
        List<Integer> list = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return list;

        // Boundaries.
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        int left = 0;
        int top = 1;
        int count = 0;
        int direction = 0;
        int i = 0;
        int j = 0;

        while(count < matrix.length * matrix[0].length) {
        	System.out.println(i + " " + j);
            list.add(matrix[i][j]);
            count ++;

            // Action.
            switch(direction % 4) {
            case 0: 
                if(j == right) {
                    right --;
                    direction ++;
                    i ++;
                } else j ++;
                break;
            case 1: 
                if(i == bottom) {
                    bottom --;
                    direction ++;
                    j --;
                } else i ++;
                break;
            case 2:
                if(j == left) {
                    left ++;
                    direction ++;
                    i --;
                } else j --;
                break;
            case 3:
                if(i == top) {
                    top ++;
                    direction ++;
                    j ++;
                } else i --;
                break;
            }
        }

        return list;
	}
}
