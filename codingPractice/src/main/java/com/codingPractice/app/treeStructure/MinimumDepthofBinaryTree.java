package com.codingPractice.app.treeStructure;

public class MinimumDepthofBinaryTree {
	public int minDepth(TreeNode root) {
        if(root==null) return 0;
        return recursive(root);
    }
	int recursive(TreeNode node) {
		if(node.left==null&&node.right==null) return 1;
        if(node.left==null) return recursive(node.right)+1;
        if(node.right==null) return recursive(node.left)+1;
		return Math.min(recursive(node.left)+1, recursive(node.right)+1);
	}
}
