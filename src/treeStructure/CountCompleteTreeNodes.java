package treeStructure;


public class CountCompleteTreeNodes {
	public int countNodes(TreeNode root) {
        int left = countLeft(root);
        int right = countRight(root);
        return left == right ?
        		1<<left-1 : 1+countNodes(root.left)+countNodes(root.right);
    }
	
	private int countLeft(TreeNode node) {
		int depth = 0;
		while(node!=null) {
			depth++;
			node = node.left;
		}
		return depth;
	}
	
	private int countRight(TreeNode node) {
		int depth = 0;
		while(node!=null) {
			depth++;
			node = node.right;
		}
		return depth;
	}
}
