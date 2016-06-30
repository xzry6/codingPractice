package dataStructure;


public class ReorderList {
	public static void reorderList(ListNode head) {
        if(head==null||head.next==null) return;
        ListNode node = head;
		ListNode next = head;
		while(true) {
			next = next.next;
			if(next==null) break;
			next = next.next;
			if(next==null) break;
			node = node.next;
		}
		next = node.next;
		node.next = null;
		node = next;
		next = null;
		while(node.next!=null) {
			ListNode temp = node.next;
			node.next = next;
			next = node;
			node = temp;
		}
		node.next = next;
		next = head;
		while(node!=null) {
			ListNode temp1 = node.next;
			ListNode temp2 = next.next;
			node.next = next.next;
			next.next = node;
			node = temp1;
			next = temp2;
		}
		return;
    }
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		new ReorderList().reorderList2(node1);
		while(node1!=null) {
			System.out.println(node1.val);
			node1 = node1.next;
		}
	}
	
	public void reorderList2(ListNode head) {  
        // write your code here
        if(head == null) return;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode node = slow;
        slow = slow.next;
        node.next = null;
        slow = reverse(slow);
        node = merge(head, slow);
    }
   
    private ListNode merge(ListNode n1, ListNode n2) {
        boolean bool = false;
        ListNode top = new ListNode(-1);
        ListNode node = top;
        while(n1 != null && n2 != null) {
            if(!bool) {
                node.next = n1;
                n1 = n1.next;
            } else {
                node.next = n2;
                n2 = n2.next;
            }
            node = node.next;
            bool = !bool;
        }
        if(n1 != null) node.next = n1;
        if(n2 != null) node.next = n2;
        return top.next;
    }
   
    private ListNode reverse(ListNode node) {
        if(node == null) return null;
        ListNode head = node;
        ListNode end = node;
        while(end.next != null) {
            ListNode temp = end.next;
            ListNode next = temp.next;
            temp.next = head;
            head = temp;
            end.next = next;
        }
        return head;
    }
}
