package com.codingPractice.app.treeStructure;

public class MaximumDepthOfBinaryTree {
	public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return recursive(root,0);
    }
	public int recursive(TreeNode node, int depth) {
		if(node==null) return depth;
		return Math.max(recursive(node.left,depth+1),recursive(node.right,depth+1));
	}
}
