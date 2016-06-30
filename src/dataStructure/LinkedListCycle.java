package dataStructure;

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		if(head==null) return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast!=null&&fast!=slow) {
        	fast = fast.next;
        	if(fast==null) break;
        	fast = fast.next;
        	slow = slow.next;
        }
        if(fast==slow) return true;
        return false;
    }
}
