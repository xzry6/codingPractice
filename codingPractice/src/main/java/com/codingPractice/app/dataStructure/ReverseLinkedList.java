package com.codingPractice.app.dataStructure;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode last = null;
        ListNode node = head;
        while(node!=null) {
        		ListNode temp = node.next;
        		node.next = last;
        		last = node;
        		node = temp;
        }
        return last;
    }
}
