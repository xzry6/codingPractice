package dataStructure;

public class RotateList {
	public static ListNode rotateRight(ListNode head, int k) {
		if(head==null) return null;
		ListNode top = new ListNode(0);
		top.next = head;
        ListNode node = top;
        int count = 0;
        while(node.next!=null) {
        	count++;
        	node = node.next;
        }
        if(count==k) return head;
        if(k>count) k = k%count;
        node.next = head;
        node = top;
        for(int i=0; i<count-k; ++i) node = node.next;
        top.next = node.next;
        node.next = null;
        return top.next;
    }
	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		a.next = b;
		rotateRight(a,2);
	}
}
