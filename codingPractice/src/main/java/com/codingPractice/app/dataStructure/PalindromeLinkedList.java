package com.codingPractice.app.dataStructure;

public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
		if(head==null) return true;
        ListNode pf = head.next;
        ListNode ps = head;
        ListNode top = head;
        boolean bool = false;
        int count = 0;
        while(pf!=null) {
        		pf = pf.next;
        		if(pf==null) {
        			bool = true;
        			break;
        		}
        		pf = pf.next;
        		ListNode next = ps.next.next;
        		ps.next.next = top;
        		top = ps.next;
        		ps.next = next;
        		count++;
        }
        ps = ps.next;
        if(!bool) {
        		top = top.next;
        		count--;
        }
        while(count-->=0) {
        		if(ps.val!=top.val) return false;
        		ps = ps.next;
        		top = top.next;
        }
        return true;
    }
	public boolean isPalindrome2(ListNode head) {
        // Write your code here
        if(head == null) return true;
        ListNode slow = head;
        ListNode fast = slow.next;
        while(fast != null) {
            fast = fast.next;
            if(fast == null) break;
            fast = fast.next;
            slow = slow.next;
        }
        
        ListNode node = slow.next;
        while(node != null) {
            ListNode next = node.next;
        		if(node == slow.next) {
        			node.next = null;
        		} else {
	            node.next = slow.next;
	            slow.next = node;
        		}
            node = next;
        }
        
        fast = slow.next;
        slow = head;
        while(fast != null) {
            if(slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
	public static void main(String[] args) {
		PalindromeLinkedList pll = new PalindromeLinkedList();
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(2);
		ListNode e = new ListNode(1);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		
		System.out.println(pll.isPalindrome2(a));
	}
}
