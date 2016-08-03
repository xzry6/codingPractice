package com.codingPractice.app.treeStructure;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        recursive(root,list);
        return list;
    }
	void recursive(TreeNode node, List<Integer> list) {
		if(node==null) return;
		recursive(node.left,list);
		list.add(node.val);
		recursive(node.right,list);
	}
	public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root==null) return list;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Set<TreeNode> set = new HashSet<TreeNode>();
        stack.add(root);
        while(!stack.isEmpty()) {
        	TreeNode node = stack.peek();
        	if(node.left!=null&&!set.contains(node.left)) {
        		stack.push(node.left);
        		continue;
        	}
        	list.add(node.val);
        	set.add(node);
        	stack.pop();
        	if(node.right!=null&&!set.contains(node.right)) {
        		stack.push(node.right);
        	}
        }
        return list;
    }
}
