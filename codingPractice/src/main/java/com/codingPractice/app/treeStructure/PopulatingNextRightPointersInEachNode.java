package com.codingPractice.app.treeStructure;

public class PopulatingNextRightPointersInEachNode {
	public void connect(TreeLinkNode root) {
        if(root==null) return;
        root.next = null;
        recursive(root);
    }
	
	void recursive(TreeLinkNode node) {
		if(node.left==null) return;
		node.left.next = node.right;
		if(node.next!=null)
			node.right.next = node.next.left;
		else node.right.next = null;
		recursive(node.left);
		recursive(node.right);
	}
}
