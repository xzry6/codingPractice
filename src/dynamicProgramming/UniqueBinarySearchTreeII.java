package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

import treeStructure.TreeNode;

public class UniqueBinarySearchTreeII {
	public static List<TreeNode> generateTrees(int n) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        list = recursive(1,n);
        
        return list;
    }
	
	static List<TreeNode> recursive(int start, int end){
		List<TreeNode> list = new ArrayList<TreeNode>();
		if(start>end) {
			list.add(null);
			return list;
		}
		for(int i=start; i<end+1; ++i){
			List<TreeNode> left = recursive(start,i-1);
			List<TreeNode> right = recursive(i+1,end);
			for(int l=0; l<left.size(); ++l){
				for(int r=0; r<right.size(); ++r){
					TreeNode temp = new TreeNode(i);
					temp.left = left.get(l);
					temp.right = right.get(r);
					list.add(temp);
				}
			}
		}
		return list;
	}
	
	static void check(TreeNode node){
		System.out.print(node.val+" ");
		if(node.left!=null) check(node.left);
		if(node.right!=null) check(node.right);
	}
	public static void main(String[] args){
		int n = 3;
		List<TreeNode> list = generateTrees(n);
		for(int i=0; i<list.size(); ++i){
			TreeNode temp = list.get(i);
			check(temp);
			System.out.println();
		}
		
	}
}
