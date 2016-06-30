package treeStructure;

import java.util.Stack;

public class BinaryTreeIterator {
	Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode node;
   
    public BinaryTreeIterator(TreeNode root) {
        // write your code here
        while(!stack.isEmpty())
            stack.pop();
        node = root;
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // write your code here
        return (node == null && stack.isEmpty());
    }
    
    //@return: return next node
    public TreeNode next() {
        // write your code here
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
        TreeNode cur = stack.pop();
        node = cur.right;
        return cur;
    }
    
    public static void main(String[] args) {
    		TreeNode n1 = new TreeNode(-22);
    		//TreeNode n2 = new TreeNode(1);
    		//n1.left = n2;
    		BinaryTreeIterator bti = new BinaryTreeIterator(n1);
    		System.out.println(bti.hasNext());
    		System.out.println(bti.next().val);
    		//System.out.println(bti.next().val);
    }
}
