package com.codingPractice.app.treeStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(root==null) return list;
		List<Integer> temp = new ArrayList<Integer>();
        LinkedList<TreeNode> link = new LinkedList<TreeNode>();
        link.add(root);
        int count = 1;
        boolean bool = true;
        while(!link.isEmpty()) {
        	TreeNode cur = null;
        	if(bool) cur = link.removeFirst();
        	else cur = link.removeLast();
        	count--;
        	temp.add(cur.val);
        	if(bool) {
        		if(cur.left!=null)
        			link.addLast(cur.left);
        		if(cur.right!=null)
        			link.addLast(cur.right);
        	} else {
        		if(cur.right!=null)
        			link.addFirst(cur.right);
        		if(cur.left!=null)
        			link.addFirst(cur.left);
        	}
        	if(count==0) {
        		list.add(temp);
        		temp = new ArrayList<Integer>();
        		count = link.size();
        		bool = !bool;
        	}
        }
        return list;
    }
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder2(TreeNode root) {
        // write your code here
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if(root == null) return list;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        tmp.add(root.val);
        list.add(tmp);
        boolean bool = true;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            tmp = new ArrayList<Integer>();
            for(int i=0; i<size; ++i) {
                TreeNode node = null;
                if(bool) {
                		node = queue.poll();
                		if(node.right != null) {
                			queue.add(node.right);
                			tmp.add(node.right.val);
                		}
                    if(node.left != null) {
                    		queue.add(node.left);
                    		tmp.add(node.left.val);
                    }
                } else {
                		node = queue.pollLast();
                		if(node.left != null) {
                    		queue.addFirst(node.left);
                    		tmp.add(node.left.val);
                    }
                    if(node.right != null) {
	            			queue.addFirst(node.right);
	            			tmp.add(node.right.val);
                    }
            		}
            }
            if(tmp.size() != 0) list.add(tmp);
            bool = !bool;
        }
        
        return list;
    }
}
