package com.codingPractice.app.dataStructure;

public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode top = new ListNode(0);
        ListNode node = top;
        while(l1 != null && l2 != null) {
        		if(l1.val > l2.val) {
        			node.next = l2;
        			l2 = l2.next;
        		} else {
        			node.next = l1;
        			l1 = l1.next;
        		}
        		node = node.next;
        }
        if(l1 != null) node.next = l1;
        if(l2 != null) node.next = l2;
        return top.next;
    }
}
