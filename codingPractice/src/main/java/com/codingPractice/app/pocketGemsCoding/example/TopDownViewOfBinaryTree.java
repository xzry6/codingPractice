package com.codingPractice.app.pocketGemsCoding.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.codingPractice.app.treeStructure.TreeNode;

public class TopDownViewOfBinaryTree {
	// Have a global map.
	Map<Integer, TreeNode> map;
	// Global maximum and minimum, easy for iteration.
	int max;
	int min;

	public List<Integer> getView(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		// Deal with null case first.
		if(root == null) return list;
		// Initialization.
		map = new HashMap<Integer, TreeNode>();
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		// Traverse and put tree nodes in map.
		traverse(root, 0);
		// Iterate map again and put treenode into list.
		for(int i=min; i<=max; ++i)
			list.add(map.get(i).val);
		// Return list.
		return list;
	}

	/*
	 * This method traverse through tree nodes recursively.
	 * @param {TreeNode} - current node.
	 * @param {int} - current position
	 *                (each son node is parent's pos(+/-)1)
	 */
	private void traverse(TreeNode node, int pos) {
		// Check null first.
		if(node == null) return;
		// Traverse sons.
		traverse(node.left, pos-1);
		traverse(node.right, pos+1);
		// Put tree node into map.
		// Since we traverse first, upper tree node will 
		// always be put into map after lower nodes.
		max = Math.max(max, pos);
		min = Math.min(min, pos);
		map.put(pos, node);
	}

	public static void main(String[] args) {
		TopDownViewOfBinaryTree tdvobt = new TopDownViewOfBinaryTree();
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		TreeNode f = new TreeNode(6);
		TreeNode g = new TreeNode(7);
		a.left = b;
		a.right = c;
		b.right = d;
		d.right = e;
		e.right = f;
//		c.right = g;
		List<Integer> list = tdvobt.getView(a);
		for(int num:list)
			System.out.print(num + " ");
	}
}
