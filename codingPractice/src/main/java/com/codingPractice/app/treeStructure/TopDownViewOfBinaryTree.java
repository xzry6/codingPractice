package com.codingPractice.app.treeStructure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class TopDownViewOfBinaryTree {
	public void printViewIterative(TreeNode root) {
		if(root == null) return;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Queue<Integer> queueIndex = new LinkedList<Integer>();
		queue.add(root);
		queueIndex.add(0);
		Map<Integer, TreeNode> map = new HashMap<Integer, TreeNode>();
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			int index = queueIndex.poll();
			if(node == null) continue;
			if(!map.containsKey(index))
				map.put(index, node);
			queue.add(node.left);
			queue.add(node.right);
			queueIndex.add(index-1);
			queueIndex.add(index+1);
		}
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		Iterator<Integer> it = map.keySet().iterator();
		while(it.hasNext()) {
			int key = it.next();
			min = Math.min(min, key);
			max = Math.max(max, key);
		}
		for(int i=min; i<=max; ++i) {
			if(map.containsKey(i))
				System.out.print(map.get(i).val+" ");
		}
	}
	
	public void printViewRecursive(TreeNode root) {
		if(root == null) return;
		Map<Integer, TreeNode> map = new HashMap<Integer, TreeNode>();
		traverse(root, 0, map);
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		Iterator<Integer> it = map.keySet().iterator();
		while(it.hasNext()) {
			int key = it.next();
			min = Math.min(min, key);
			max = Math.max(max, key);
		}
		for(int i=min; i<=max; ++i) {
			if(map.containsKey(i))
				System.out.print(map.get(i).val);
		}
		System.out.println();
	}
	
	private void traverse(TreeNode node, int index, Map<Integer, TreeNode> map) {
		if(node == null) return;
		traverse(node.left, index-1, map);
		traverse(node.right, index+1, map);
		map.put(index, node);
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		n1.left = n2;
		n1.right = n3;
		n2.right = n4;
		n4.right = n5;
		n5.right = n6;
		n6.right = n7;
		new TopDownViewOfBinaryTree().printViewRecursive(n1);
		new TopDownViewOfBinaryTree().printViewIterative(n1);
	}
}
