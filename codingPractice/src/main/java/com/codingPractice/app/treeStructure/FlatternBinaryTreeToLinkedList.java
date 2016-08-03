package com.codingPractice.app.treeStructure;

public class FlatternBinaryTreeToLinkedList {
	public void flatten(TreeNode root) {
        if(root==null) return;
        recursive(root,null);
    }
	void recursive(TreeNode cur, TreeNode next) {
		if(cur.right!=null) {
			recursive(cur.right,next);
			next = cur.right;
		}
		if(cur.left!=null) {
			recursive(cur.left, next);
			next = cur.left;
		}
		cur.right = next;
		cur.left = null;
	}
}
