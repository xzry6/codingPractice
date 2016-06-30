package dataStructure;

public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
        ListNode top = new ListNode(0);
        top.next = head;
        ListNode node = top;
        while(node.next!=null) {
        	if(node.next.val==val)
        		node.next = node.next.next;
        	else node = node.next;
        }
        return top.next;
    }
}
