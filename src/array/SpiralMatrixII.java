package array;

public class SpiralMatrixII {
	public static int[][] generateMatrix(int n) {
        int[][] table = new int[n][n];
        int i = 0, j = 0;
        int count = 1;
        int flag = 1;
        while(count!=n*n+1) {
        	table[i][j] = count;
        	if(flag==1&&(j==n-1||table[i][j+1]!=0)) flag = 2;
        	if(flag==2&&(i==n-1||table[i+1][j]!=0)) flag = 3;
        	if(flag==3&&(j==0||table[i][j-1]!=0)) flag = 4;
        	if(flag==4&&(i==0||table[i-1][j]!=0)) flag = 1;
        	switch(flag) {
	        	case 1: j++;
	        			break;
	        	case 2: i++;
	        			break;
	        	case 3: j--;
	        			break;
	        	case 4: i--;
	        			break;
        	}
        	count++;
        }
        return table;
    }
	public static void main(String[] args) {
		int[][] a = generateMatrix(1);
		for(int i=0; i<a.length; ++i) {
			for(int j=0; j<a[0].length; ++j) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}
}
