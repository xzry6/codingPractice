package array;

public class RotateImage {
	public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i=0; i<(n+1)/2; ++i){
        	for(int j=i; j<n-i-1; ++j){ 
        		int temp = matrix[j][n-i-1];
        		matrix[j][n-i-1] = matrix[i][j];
        		matrix[i][j] = matrix[n-j-1][i];
        		matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
        		matrix[n-i-1][n-j-1] = temp;
        	}
        }
    }
	public static void main(String[] args) {
		int[][] a = {{1,2},//,3,4,5},
					{2,3}//,4,5,6},
					//{3,4,5,6,7},
					//{4,5,6,7,8},
					//{5,6,7,8,9},
					};
		rotate(a);
		for(int i=0; i<a.length; ++i) {
			for(int j=0; j<a.length; ++j) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}
}
