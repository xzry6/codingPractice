package dataStructure;

public class IntersectionOfTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA==null&&headB==null) return null;
        int lenA = checkLen(headA);
        int lenB = checkLen(headB);
        ListNode common = null;
        for(int n=0; n<Math.min(lenA, lenB); ++n) {
        	ListNode nodeA = posAt(headA, lenA-n);
        	ListNode nodeB = posAt(headB, lenB-n);
        	if(nodeA!=nodeB) break;
        	common = nodeA;
        }
        return common;
    }
	int checkLen(ListNode node) {
		int len = 0;
		while(node!=null) {
			node = node.next;
			len++;
		}
		return len;
	}
	ListNode posAt(ListNode head, int len) {
		for(int l=0; l<len-1; ++l) head = head.next;
		return head;
	}
	/*boolean checkCycle(ListNode head) {
		ListNode node = head.next;
		while(node!=null) {
			if(node==head) return true;
			node = node.next;
		}
		return false;
	}*/
}
