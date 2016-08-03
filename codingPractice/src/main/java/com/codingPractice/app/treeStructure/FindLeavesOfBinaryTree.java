package com.codingPractice.app.treeStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindLeavesOfBinaryTree {
	public static void main(String[] args) {
		FindLeavesOfBinaryTree f = new FindLeavesOfBinaryTree();
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		List<List<Integer>> list = f.findLeaves(a);
		for(List<Integer> temp:list) {
			for(int num:temp) System.out.print(num);
			System.out.println();
		}
	}
	 // Global properties
    Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        // Deal with empty.
        if(root == null) return list;
        // Get max depth.
        int max = getDepth(root);
        for(int i = 0; i <= max; ++ i) {
            list.add(map.get(i));
        }
        return list;
    }

    private int getDepth(TreeNode node) {
        if(node == null) return -1;
        int depth = Math.max(getDepth(node.left), getDepth(node.right)) + 1;
        if(map.containsKey(depth)) {
            List<Integer> temp = map.get(depth);
            temp.add(node.val);
        } else {
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(node.val);
            map.put(depth, temp);
        }
        return depth;
    }
}
