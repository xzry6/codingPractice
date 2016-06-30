package dynamicProgramming;

public class MaximumSquare {
	public int maximalSquare(char[][] matrix) {
		if(matrix.length==0) return 0;
		int[] vector = new int[matrix[0].length];
		int maximum = 0;
		for(int c=0; c<matrix[0].length; ++c) {
			vector[c] = matrix[0][c]-48;
			maximum = Math.max(vector[c], maximum);
		}
		for(int i=1; i<matrix.length; ++i) {
			int before = vector[0];
			vector[0] = matrix[i][0]-48;
			for(int j=1; j<matrix[i].length; ++j) {
				int temp = vector[j];
				if(matrix[i][j]=='1')
					vector[j] = Math.min(Math.min(vector[j-1],vector[j]),before)+1;
				else 
					vector[j] = 0;
				before = temp;
				if(vector[j]>maximum) maximum = vector[j];
			}
		}
		return maximum*maximum;
    }
	public static void main(String[] args) {
		MaximumSquare ms = new MaximumSquare();
		char[][] matrix = {
							{'1','0','1','0','0'},
							{'1','0','1','1','1'},
							{'1','1','1','1','1'},
							{'1','0','0','1','0'}
						  };
		System.out.println(ms.maximalSquare(matrix));
	}
	
	
}
