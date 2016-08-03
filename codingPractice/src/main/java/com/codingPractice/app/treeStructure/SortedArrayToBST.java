package com.codingPractice.app.treeStructure;

public class SortedArrayToBST {
	public TreeNode sortedArrayToBST(int[] num) {
		if(num.length==0) return null;
		int left = num.length/2;
		int right = num.length-left-1;
		int[] leftArray = new int[left];
		int[] rightArray = new int[right];
		System.arraycopy(num, 0, leftArray, 0, left);
		System.arraycopy(num, num.length/2+1, rightArray, 0, right);
        TreeNode root = new TreeNode(num[left]);
        root.left = sortedArrayToBST(leftArray);
        root.right = sortedArrayToBST(rightArray);
        return root;
    }
}
