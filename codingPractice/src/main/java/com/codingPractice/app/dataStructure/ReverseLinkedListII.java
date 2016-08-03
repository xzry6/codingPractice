package com.codingPractice.app.dataStructure;

public class ReverseLinkedListII {
	public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode top = new ListNode(0);
        top.next= head;
        if(head==null||m==n) return top.next;
        ListNode pre = top;
        for(int i=1; i<m; ++i) 
        	pre = pre.next;
        ListNode cur = pre.next;
        ListNode nex = cur.next;
        for(int i=m; i<n; ++i) {
        	cur.next = nex.next;
        	nex.next = pre.next;
        	pre.next = nex;
        	nex = cur.next;
        }
        return top.next;
    }
	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		a.next = b;
		b.next = c;
		c.next = d;
		ListNode head = reverseBetween(a,2,4);
		while(head!=null) {
			System.out.println(head.val);
			head = head.next;
		}
		
		
		
	}
}
