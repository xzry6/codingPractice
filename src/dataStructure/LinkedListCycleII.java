package dataStructure;

public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
        if(head==null) return null;
        ListNode n1 = head;
        ListNode n2 = null;
        while(n1!=n2) {
        	if(n1==null) return null;
        	n1 = n1.next;
        	if(n2==null) n2 = n1;
        	else n2 = n2.next;
        	if(n1==null) return null;
        	n1 = n1.next;
        }
        n1 = head;
        while(n1!=n2) {
        	n1 = n1.next;
        	n2 = n2.next;
        }
        return n1;
    }
}
