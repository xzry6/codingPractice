package com.codingPractice.app.treeStructure;

public class SortedListToBST {
	static ListNode head;
	public static TreeNode sortedListToBST(ListNode p) {
		head = p;
		if(head==null) return null;
        int length = 0;
        ListNode point = head;
        while(point!=null){
        	length++;
        	point = point.next;
        }
        return recursive(0, length-1);
    }
	static TreeNode recursive(int start, int end) {
		if(start>end) return null;
		int mid = (start+end+1)/2;
		TreeNode left = recursive(start, mid-1);
		TreeNode node = new TreeNode(head.val);
		node.left = left;
		head = head.next;
		node.right = recursive(mid+1, end);
		return node;
	}
	
	public static void main(String[] args){
		ListNode head = new ListNode(1);
		ListNode sec = new ListNode(2);
		ListNode thi = new ListNode(3);
		ListNode fou = new ListNode(4);
		head.next = sec;
		sec.next = thi;
		thi.next = fou;
		//System.out.println(head.val);
		//head = head.next;
		//System.out.println(head.val);
		TreeNode root = sortedListToBST(head);
		System.out.println(root.val);
		System.out.println(root.left.val);
		System.out.println(root.right.val);
		System.out.println(root.left.left.val);
		System.out.println(root.left.right);
		//System.out.println(root.right.right.val);
	}
}
