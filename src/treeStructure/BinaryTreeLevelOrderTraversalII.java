package treeStructure;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root==null) return list;
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        int count = 1;
        List<Integer> temp = new ArrayList<Integer>();
        while(!queue.isEmpty()) {
        	TreeNode cur = queue.poll();
        	temp.add(cur.val);
        	count--;
        	if(cur.left!=null) queue.add(cur.left);
        	if(cur.right!=null) queue.add(cur.right);
        	if(count==0) {
        		list.add(0, temp);
        		temp = new ArrayList<Integer>();
        		count = queue.size();
        	}
        }
        return list;
    }
}
