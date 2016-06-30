package dataStructure;

public class RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode top = new ListNode(0);
        top.next = head;
        ListNode node = top.next;
        int count = 0;
        while(node != null) {
        		node = node.next;
        		count ++;
        }
        node = top;
        count = count-n;
        while(count-- > 0) 
        		node = node.next;
        node.next = node.next.next;
        return top.next;
    }
}
