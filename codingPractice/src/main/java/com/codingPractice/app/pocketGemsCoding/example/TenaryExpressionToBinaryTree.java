package com.codingPractice.app.pocketGemsCoding.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TenaryExpressionToBinaryTree {
	// Tree Node structure.
	private static class TreeNode {
		// A tree node should have value and left and right nodes.
		public char val;
		public TreeNode left; 
		public TreeNode right;

		// Initialize a tree node only using value.
		TreeNode(char val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

	public static TreeNode ternaryExpressionToBinaryTree(String expression) {
		if(expression == null || expression.length() == 0) {
			return null;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();
		char[] array = expression.toCharArray();
		TreeNode root = new TreeNode(array[0]);
		stack.push(root);
		for(int i=1; i<array.length; i+=2) {
			char c = array[i];
			TreeNode node = new TreeNode(array[i+1]);
			if(c == '?') {
				TreeNode parent = stack.peek();
				parent.left = node;
			} else {
				stack.pop();
				TreeNode parent = stack.pop();
				parent.right = node;
			}
			stack.push(node);
		}		

		return root;
	}

	public static TreeNode ternaryExpressionToBinaryTree2(String expression) {
		if(expression == null || expression.length() == 0) 
			return null;

		char[] array = expression.toCharArray();
		boolean[] mask = new boolean[array.length];
		TreeNode root = new TreeNode(array[0]);
		traverse(root, array, 1, mask);

		return root;
	}

	private static void traverse(TreeNode node, char[] array, int position, boolean[] mask) {
		if(position >= array.length) return;
		TreeNode subNode = node;
		for(int i=position; i<array.length; i+=2) {
			if(mask[i]) continue;
			char c = array[i];
			if(c == '?') {
				if(!subNode.equals(node))
					traverse(subNode, array, i, mask);
				else {
					subNode = new TreeNode(array[i+1]);
					node.left = subNode;
				}
			} else if(c == ':') {
				if(node.left != null && node.right != null) return;
				subNode = new TreeNode(array[i+1]);
				node.right = subNode;
			}
			mask[i] = true;
		}
	}

	public static void main(String[] args) {
		TreeNode root = TenaryExpressionToBinaryTree.ternaryExpressionToBinaryTree("a?b?c:d?f:g:e?x:y");

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int number = 1;
		int level = 0;
		Loop:
		while(number != 0) {
			System.out.print("level "+level+": ");
			int count = number;
			for(int i=0; i<count; ++i) {
				if(queue.isEmpty()) { break Loop; }
				TreeNode node = queue.poll();
				number --;
				System.out.print(node.val+" ");
				if(node.left != null) {
					queue.offer(node.left);
					number ++;
				}
				if(node.right != null) {
					queue.offer(node.right);
					number ++;
				}
			}
			level ++;
			System.out.println();
		}
	}
	
	public static TreeNode ternaryExpressionToBinaryTree3(String expression) {
		// Deal with null and empty cases first.
		if(expression == null || expression.length() == 0) return null;
		// Use a stack storing TreeNodes.
		Stack<TreeNode> stack = new Stack<TreeNode>();
		// Create a head node.
		TreeNode head = new TreeNode(expression.charAt(0));
		stack.push(head);
		// Have an iteration on expression string.
		for(int i=1; i<expression.length(); i+=2) {
			char c = expression.charAt(i);
			char letter = expression.charAt(i+1);
			if(c == '?') {
				TreeNode node = stack.peek();
				TreeNode newNode = new TreeNode(letter);
				node.left = newNode;
				stack.push(newNode);
			} else if(c == ':') {
				stack.pop();
				TreeNode node = stack.pop();
				TreeNode newNode = new TreeNode(letter);
				node.right = newNode;
				stack.push(newNode);
			}
		}
		// Return head node.
		return head;
	}

}
