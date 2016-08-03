package com.codingPractice.app.treeStructure;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
	List<List<Integer>> list;
	int SUM;
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		list = new ArrayList<List<Integer>>();
        if(root==null) return list;
		SUM = sum;
		List<Integer> pre = new ArrayList<Integer>();
		pre.add(root.val);
		if(root.left==null&&root.right==null&&root.val==sum) list.add(pre);
		if(root.left!=null) recursive(root.left, root.val, pre);
		if(root.right!=null) recursive(root.right, root.val, pre);
		return list;
    }
	void recursive(TreeNode node, int total, List<Integer> pre) {
		total += node.val;
		List<Integer> cur = new ArrayList<Integer>(pre);
		cur.add(node.val);
		if(node.left==null&&node.right==null) {
			if(SUM==total) list.add(cur);
			return;
		}
		if(node.left!=null) recursive(node.left, total, cur);
		if(node.right!=null) recursive(node.right, total, cur);
	}
}
