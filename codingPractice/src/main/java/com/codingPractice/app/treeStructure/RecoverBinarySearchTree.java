package com.codingPractice.app.treeStructure;

public class RecoverBinarySearchTree {
	TreeNode first;
	TreeNode second;
	TreeNode pre = new TreeNode(Integer.MIN_VALUE);
	public void recoverTree(TreeNode root) {
        recursive(root);
        if(first==null||second==null) return;
        int val = first.val;
        first.val = second.val;
        second.val = val;
    }
	void recursive(TreeNode node) {
		if(node==null) return;
		recursive(node.left);
		if(pre.val>node.val) {
			if(first==null) first = pre;
			second = node;
		}
		pre = node;
		recursive(node.right);
	}
}
