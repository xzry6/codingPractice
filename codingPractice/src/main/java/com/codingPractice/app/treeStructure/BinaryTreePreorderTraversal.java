package com.codingPractice.app.treeStructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root!=null){
        	list.add(root.val);
			recursive(root.left, list);
			recursive(root.right, list);
        }
        return list;
    }
	void recursive(TreeNode node, List<Integer> list){
		if(node!=null){
			list.add(node.val);
			recursive(node.left, list);
			recursive(node.right, list);
		}
	}
	public List<Integer> preorderTraversal1(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(!stack.isEmpty()||root!=null){
			if(root!=null){
				list.add(root.val);
				stack.push(root);
				root = root.left;
			} else{
				root = stack.pop().right;
			}
		}
		return list;
	}
}
