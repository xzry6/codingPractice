package com.codingPractice.app.dataStructure;

public class InsertionSortList {
	public static ListNode insertionSortList(ListNode head) {
        ListNode top = new ListNode(0);
        //ListNode cur = head;
        top.next = head;
        int count = 0;
		while(head!=null) {
			ListNode temp = top;
			ListNode next = head.next;
			for(int i=0; i<count; ++i){
				if(head.val>=temp.next.val)
					temp = temp.next;
				else {
					head.next = temp.next;
					temp.next = head;
					break;
				}
			}
			count++;
			head = next;
		}
		return top.next;
    }
	public static void main(String[] args) {
		//ListNode c = new ListNode(3);
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(1);
		a.next = b;
		//b.next = c;
		System.out.println(insertionSortList(a).val);
	}
}
