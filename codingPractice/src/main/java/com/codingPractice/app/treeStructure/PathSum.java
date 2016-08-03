package com.codingPractice.app.treeStructure;

public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        return recursive(root, sum, 0);
    }
	boolean recursive(TreeNode node, int sum, int total) {
		if(node==null) return false;
		total += node.val;
		if(node.left==null&&node.right==null) return total==sum;
		return recursive(node.left, sum, total)||recursive(node.right, sum, total);
	}
	
}
