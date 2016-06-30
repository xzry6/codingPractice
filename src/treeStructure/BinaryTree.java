package treeStructure;

import java.util.Stack;

public class BinaryTree {
	public boolean isSymmetric(TreeNode root){
		TreeNode left;
		TreeNode right;
		Stack<TreeNode> leftS = new Stack<TreeNode>();
		Stack<TreeNode> rightS = new Stack<TreeNode>();
		if(root==null) return true;
		else if(root.left==null&&root.right==null) return true;
		else if(root.left==null||root.right==null) return false;
		else{
			leftS.add(root.left);
			rightS.add(root.right);
		}
		while(!leftS.isEmpty()&&!rightS.isEmpty()){
			left = leftS.pop();
			right = rightS.pop();
			if(left==null&&right==null) continue;
			if((left!=null&&right==null)||(left==null&&right!=null))
				return false;
			else if(left.val!=right.val)
				return false;
			else {
				leftS.push(left.left);
				rightS.push(right.right);
				leftS.push(left.right);
				rightS.push(right.left);
			}
		}
		return true;
	}
}


/*class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}*/