package com.codingPractice.app.treeStructure;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();
        if(root!=null) recursive("",root,list);
        return list;
    }
	
	private void recursive(String s, TreeNode node, List<String> list) {
		s = s+node.val;
		if(node.left==null&&node.right==null) list.add(s);
		if(node.left!=null) recursive(s+"->",node.left,list);
		if(node.right!=null) recursive(s+"->",node.right,list);
	}
}
