package com.codingPractice.app.treeStructure;

public class BinaryTreeMaximumPathSum {
	int max;
	public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        if(root!=null) {
        	int left = Math.max(recursive(root.left),0);
        	int right = Math.max(recursive(root.right),0);
            return Math.max(max, root.val+left+right);
        } else return 0;
    }
	int recursive(TreeNode node) {
		if(node!=null){
			int left = recursive(node.left);
			if(left<0) left = 0;
			int right = recursive(node.right);
			if(right<0) right = 0;
			max = Math.max(max, node.val+left+right);
			return Math.max(node.val+left, node.val+right);
		} else return 0;
	}
}
