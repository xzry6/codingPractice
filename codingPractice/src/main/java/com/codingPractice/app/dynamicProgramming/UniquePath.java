package com.codingPractice.app.dynamicProgramming;

public class UniquePath {
	public static int uniquePaths(int m, int n) {
        return position(m,n,0,0);
    }
	static int position(int m, int n, int x, int y){
		if(x==m-1&&y==n-1) return 1;
		if(x==m-1) return position(m,n,x,y+1);
		if(y==n-1) return position(m,n,x+1,y);
		else return position(m,n,x,y+1)+position(m,n,x+1,y);
	}
	public static int uniquePath(int m, int n){
		int[] temp = new int[n];
		temp[0] = 1;
		for(int i=0; i<m; ++i){
			for(int j=1; j<n; ++j){
				temp[j] += temp[j-1];
			}
		}
		return temp[n-1];
	}
	public static void main(String[] args){
		System.out.println(uniquePaths(23,12));
	}
}
