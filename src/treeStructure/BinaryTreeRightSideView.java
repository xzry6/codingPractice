package treeStructure;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
	public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        recursive(root,0,list);
        return list;
    }
	static void recursive(TreeNode node, int depth, List<Integer> list) {
		if(node==null) return;
		if(depth<list.size()) list.remove(depth);
		list.add(depth, node.val);
		recursive(node.left,depth+1,list);
		recursive(node.right,depth+1,list);
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		root.left = b; root.right = d;
		b.right = c;
		List<Integer> list = rightSideView(root);
		for(int i=0; i<list.size(); ++i) {
			System.out.println(list.get(i));
		}
		
		
	}
}
