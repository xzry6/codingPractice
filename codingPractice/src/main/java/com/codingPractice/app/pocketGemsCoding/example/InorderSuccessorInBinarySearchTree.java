package com.codingPractice.app.pocketGemsCoding.example;

import com.codingPractice.app.treeStructure.TreeNode;

public class InorderSuccessorInBinarySearchTree {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
       if(root == null || p == null) return null;

        TreeNode node = root;
        TreeNode pre = null;
        while(node != null && node.val != p.val) {
            if(node.val > p.val) {
                pre = node;
                node = node.left;
            } else {
                node = node.right;
            }
        }
        if(node == null) return null;
        if(node.right != null) {
            node = node.right;
            while(node.left != null) {
                node = node.left;
            }
            return node;
        }
        return pre;
    }
}
