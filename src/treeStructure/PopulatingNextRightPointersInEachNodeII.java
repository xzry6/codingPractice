package treeStructure;

public class PopulatingNextRightPointersInEachNodeII {
	public static void connect(TreeLinkNode root) {
		if(root==null) return;
        root.next = null;
        recursive(root);
    }
	
	static void recursive(TreeLinkNode node) {
		if(node.left==null&&node.right==null) return;
		if(node.left!=null&&node.right!=null) {
			node.left.next = node.right;
		} 
		TreeLinkNode defaultSon = node.right;
		if(defaultSon==null) defaultSon = node.left;
		TreeLinkNode next = node.next;
		TreeLinkNode nextSon = null;
		while(next!=null) {
			if(next.left!=null) {
				nextSon = next.left;
				break;
			}
			if(next.right!=null) {
				nextSon = next.right;
				break;
			}
			next = next.next;
		}
		if(next!=null) 
			defaultSon.next = nextSon;
		else defaultSon.next = null;
		if(node.right!=null)
			recursive(node.right);
		if(node.left!=null)
			recursive(node.left);
	}

	
	
	public static void main(String[] args) {
		TreeLinkNode a = new TreeLinkNode(2);
		TreeLinkNode b = new TreeLinkNode(1);
		TreeLinkNode c = new TreeLinkNode(3);
		TreeLinkNode d = new TreeLinkNode(0);
		TreeLinkNode e = new TreeLinkNode(7);
		TreeLinkNode f = new TreeLinkNode(9);
		TreeLinkNode g = new TreeLinkNode(1);
		TreeLinkNode h = new TreeLinkNode(2);
		TreeLinkNode i = new TreeLinkNode(1);
		TreeLinkNode j = new TreeLinkNode(0);
		TreeLinkNode k = new TreeLinkNode(8);
		TreeLinkNode l = new TreeLinkNode(8);
		TreeLinkNode m = new TreeLinkNode(7);
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		c.left = f;
		c.right = g;
		d.left = h;
		e.left = i;
		e.right = j;
		g.left = k;
		g.right = l;
		j.left = m;
		connect(a);
		
	}
}
