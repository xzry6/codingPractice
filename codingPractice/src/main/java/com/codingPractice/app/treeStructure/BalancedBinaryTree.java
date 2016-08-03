package com.codingPractice.app.treeStructure;

public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int left = recursive(root.left);
        int right = recursive(root.right);
        if(Math.abs(left-right)>1||left==-1||right==-1) return false;
        else return true;
    }
	int recursive(TreeNode node) {
		if(node!=null) {
			int left = recursive(node.left);
			int right = recursive(node.right);
			if(Math.abs(left-right)>1||left==-1||right==-1) return -1;
			else return Math.max(left, right)+1;
		}
		else return 0;
	}
	
	
}
