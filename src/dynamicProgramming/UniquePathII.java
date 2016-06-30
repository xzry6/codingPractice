package dynamicProgramming;

import java.util.Arrays;

public class UniquePathII {
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] temp = new int[n];
        temp[0] = 1;
        for(int i=0; i<m; ++i){
        	temp[0] *= 1-obstacleGrid[i][0];
        	for(int j=1; j<n; ++j)
        		temp[j] = (temp[j]+temp[j-1]*(1-obstacleGrid[i][j-1]))*(1-obstacleGrid[i][j]);
            System.out.println(Arrays.toString(temp));
        }
        return temp[n-1];
    }
	public static void main(String[] args){
		int[][] grid = new int[1][1];
		//grid[1][1] = 1;
		//grid[1][0] = 1;
		//grid[0][1] = 1;
		System.out.println(uniquePathsWithObstacles(grid));
	}
}
