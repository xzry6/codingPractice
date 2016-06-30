package dataStructure;

public class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
        ListNode top = new ListNode(0);
        top.next = head;
        ListNode node = top; 
        while(node.next != null && node.next.next != null) {
        		ListNode node1 = node.next;
        		ListNode node2 = node1.next;
        		ListNode next = node2.next;
        		node.next = node2;
        		node2.next = node1;
        		node1.next = next;
        		node = node1;
        }
        return top.next;
    }
}
