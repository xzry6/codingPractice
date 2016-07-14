package treeStructure;

/**
 * Given a binary tree, find the length of the longest consecutive sequence path.
 * The path refers to any sequence of nodes from some starting node to any node
 * in the tree along the parent-child connections. 
 * The longest consecutive path need to be from parent to child (cannot be the reverse).
 * 
 * For example,
	   1
	    \
	     3
	    / \
	   2   4
	        \
	         5
 * Longest consecutive sequence path is 3-4-5, so return 3.
 * 
	   2
	    \
	     3
	    / 
	   2    
	  / 
	 1
 * Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
 * 
 * @author Sean
 *
 */
public class BinaryTreeLongestConsecutiveSequence {

	int max = 0;

    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        recursive(root, 1);
        return this.max;
    }

    private void recursive(TreeNode node, int curLength) {
        this.max = Math.max(this.max, curLength);

        if(node == null) return;
        if(node.left != null) {
            if(node.left.val == node.val + 1) recursive(node.left, curLength + 1);
            else recursive(node.left, 1);
        }
        if(node.right != null) {
            if(node.right.val == node.val + 1) recursive(node.right, curLength + 1);
            else recursive(node.right, 1);
        }
    }
}
