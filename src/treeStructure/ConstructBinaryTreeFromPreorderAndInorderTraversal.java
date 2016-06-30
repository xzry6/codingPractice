package treeStructure;


public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0||preorder.length!=inorder.length) return null;
        return recursive(preorder,inorder,0,0,preorder.length);
    }
	static TreeNode recursive(int[] pre, int[] in, int pos ,int start, int end) {
		if(pos==pre.length||start>=end) return null;
		int num = pre[pos];
		TreeNode cur = new TreeNode(num);
		int index = -1;
		for(int i=start; i<end; ++i) {
			if(in[i]==num) index = i;
		}
		cur.left = recursive(pre,in,pos+1,start,index);
		cur.right = recursive(pre,in,pos+index-start+1,index+1,end);
		return cur;
	}
	public static void main(String[] args) {
		//int[] a = {-1};
		//int[] b = {-1};
		//TreeNode node = buildTree(a,b);
		
	}
}
