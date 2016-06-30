package dataStructure;

import java.util.HashMap;


public class RemoveDuplicatesfromSortedList {
	public static ListNode deleteDuplicates(ListNode head) {
		if(head==null) return null;
		HashMap<Integer, ListNode> map = new HashMap<Integer, ListNode>();
		ListNode node = head;
		map.put(node.val, node);
		while(node.next!=null) {
			int value = node.next.val;
			if(map.containsKey(value)) {
				node.next = node.next.next;
			} else{
				map.put(value, node.next);
				node = node.next;
			}
		}
		return head;
	}
	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(1);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(1);
		a.next = b;
		b.next = c;
		c.next = d;
		ListNode node = deleteDuplicates(a);
		while(node!=null) {
			System.out.println(node.val);
			node = node.next;
		}
	}
}
