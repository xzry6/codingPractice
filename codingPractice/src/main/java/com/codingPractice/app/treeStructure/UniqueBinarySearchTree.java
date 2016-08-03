package com.codingPractice.app.treeStructure;

public class UniqueBinarySearchTree {
	public static int numTrees(int n) {
        int[] array = new int[n+1];
        array[0] = 1;
        array[1] = 1;
        for(int i=2; i<n+1; ++i) {
        	for(int j=0; j<i; ++j) {
        		array[i] += array[j]*array[i-j-1];
        	}
        }
        return array[n];
    }
	public static void main(String[] args) {
		System.out.println(numTrees(3));
	}
}
