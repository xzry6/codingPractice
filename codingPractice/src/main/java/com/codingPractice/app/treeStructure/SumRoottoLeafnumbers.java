package com.codingPractice.app.treeStructure;

public class SumRoottoLeafnumbers {
	public int sumNumbers(TreeNode root) {
        return recursive(root,0);
    }
	int recursive(TreeNode node, int pre) {
		if(node==null) return 0;
		int next = pre*10+node.val;
		return Math.max(recursive(node.left,next)+recursive(node.right,next),next);
	}
}
