package treeStructure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Serialization is the process of converting a data structure or object
 * into a sequence of bits so that it can be stored in a file or memory buffer,
 * or transmitted across a network connection link to be reconstructed later
 * in the same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary tree.
 * There is no restriction on how your serialization/deserialization
 * algorithm should work. You just need to ensure that a binary tree
 * can be serialized to a string and this string can be deserialized
 * to the original tree structure.
 * 
 * 
 * For example, you may serialize the following tree

	    1
	   / \
	  2   3
	     / \
	    4   5
	    
 * as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree.
 * You do not necessarily need to follow this format,
 * so please be creative and come up with different approaches yourself.
 * 
 * Note: Do not use class member/global/static variables to store states.
 * Your serialize and deserialize algorithms should be stateless.
 * 
 * @author Sean
 *
 */
public class SerializeAndDeserializeBinaryTree {
	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		a.left = b;
		a.right = c;
		c.left = d;
		c.right = e;
		SerializeAndDeserializeBinaryTree sadbt = new SerializeAndDeserializeBinaryTree();
		sadbt.deserialize(sadbt.serialize(a));
	}


	public String serialize(TreeNode root) {
        if(root == null) return new String();

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if(node == null) sb.append("null");
            else {
            		sb.append(node.val);
            		queue.offer(node.left);
            		queue.offer(node.right);
            }

            sb.append(",");
        }

        return sb.substring(0, sb.length() - 1).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;

        String[] arr = data.split(",");
        if(arr == null || arr.length == 0) return null;

        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int index = 1;

        while(index < arr.length && !queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode left = null;
            TreeNode right = null;
            if(!arr[index].equals("null")) {
                left = new TreeNode(Integer.parseInt(arr[index]));
                queue.offer(left);
            }
            if(index < arr.length - 1 && !arr[index + 1].equals("null")) {
                right = new TreeNode(Integer.parseInt(arr[index + 1]));
                queue.offer(right);
            }
            node.left = left;
            node.right = right;
            index += 2;
        }

        return root;
    }
}
