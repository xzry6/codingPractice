package com.codingPractice.app.treeStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root == null) return list;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> temp = new ArrayList<Integer>();
        queue.add(root);
        int count = 1;
        while(!queue.isEmpty()) {
        		if(count == 0) {
        			list.add(temp);
        			temp = new ArrayList<Integer>();
        			count = queue.size();
        		}
        		TreeNode node = queue.poll();
        		temp.add(node.val);
        		if(node.left != null) queue.add(node.left);
        		if(node.right != null) queue.add(node.right);
        		count --;
        }
        list.add(temp);
        return list;
    }
	
	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		a.right = b;
		b.left = c;
		List<List<Integer>> list = new BinaryTreeLevelOrderTraversal().levelOrder(a);
		for(List<Integer> temp:list) {
			for(int i:temp) 
				System.out.print(i+" ");
			System.out.println();
		}
			
	}
}
