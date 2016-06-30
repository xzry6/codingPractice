package treeStructure;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		if(postorder.length==0||postorder.length!=inorder.length) return null;
        return recursive(inorder,postorder,postorder.length-1,0,postorder.length);
    }
	static TreeNode recursive(int[] in, int[] post, int pos, int start, int end) {
		if(pos==-1||start>=end) return null;
		int num = post[pos];
		TreeNode node = new TreeNode(num);
		int index = -1;
		for(int i=start; i<end; ++i) {
			if(in[i]==num) {
				index = i;
				break;
			}
		}
		node.left = recursive(in,post,pos-end+index,start,index);
		node.right = recursive(in,post,pos-1,index+1,end);
		return node;
	}
	public static void main(String[] args) {
		//int[] a = {2,1};
		//int[] b = {2,1};
		//TreeNode node = buildTree(a,b);
		
	}
}
