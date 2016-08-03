package com.codingPractice.app.treeStructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        recursive(root,list);
        return list;
    }
	private void recursive(TreeNode node, List<Integer> list) {
		if(node==null) return;
		recursive(node.left, list);
		recursive(node.right, list);
		list.add(node.val);
	}
	public static List<Integer> postorderTraversal1(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()&&root!=null){
			root = stack.peek();
			if(root.right==null&&root.left==null) {
				list.add(root.val);
				stack.pop();
			}
			if(root.right!=null) {
				stack.push(root.right);
				root.right = null;
			}
			if(root.left!=null) {
				stack.push(root.left);
				root.left = null;
			}
		}
		return list;
	}
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		node1.right = node2;
		List<Integer> list = postorderTraversal1(node1);
		for(int i=0; i<list.size(); ++i) {
			System.out.println(list.get(i));
		}
	}
}
