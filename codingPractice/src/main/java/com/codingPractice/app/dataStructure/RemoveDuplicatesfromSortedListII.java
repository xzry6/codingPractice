package com.codingPractice.app.dataStructure;

import java.util.HashMap;

public class RemoveDuplicatesfromSortedListII {
	public static ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
		ListNode top = new ListNode(-1);
		top.next = head;
		ListNode slow = top;
		boolean bool = false;
		while(slow.next!=null) {
			ListNode fast = slow.next;
			while(fast.next!=null&&fast.val==fast.next.val) {
				fast = fast.next;
				bool = true;
			}
			if(bool) {
				bool = false;
				slow.next = fast.next;
			}
			else slow = fast;
		}
		return top.next;
    }
	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(1);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		//ListNode e = new ListNode(4);
		//ListNode f = new ListNode(4);
		//ListNode g = new ListNode(4);
		//ListNode h = new ListNode(4);
		a.next = b;
		b.next = c;
		c.next = d;
		//d.next = e;
		//e.next = f;
		//f.next = g;
		//g.next = h;
		ListNode node = deleteDuplicates2(a);
		while(node!=null) {
			System.out.println(node.val);
			node = node.next;
		}
	}
	
	public static ListNode deleteDuplicates2(ListNode head) {

	if(head == null) return null;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    ListNode top = new ListNode(-1);
    top.next = head;
    ListNode node = head;
    while(node != null) {
        if(map.containsKey(node.val)) 
            map.put(node.val, map.get(node.val)+1);
        else map.put(node.val, 1);
        node = node.next;
    }
    node = top;
    while(node != null) {
        ListNode next = node.next;
        while(next != null && map.get(next.val) > 1)
            next = next.next;
        node.next = next;
        node = node.next;
    }
    return top.next;
	}
}
