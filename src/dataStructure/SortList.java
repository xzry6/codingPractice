package dataStructure;

public class SortList {
	public static ListNode sortList(ListNode head) {
		ListNode top = new ListNode(Integer.MIN_VALUE);
		ListNode temp = top;
		top.next = head;
		int count = 0;
		while(temp.next!=null) {
			temp = temp.next;
			count++;
		}
		System.out.println(count);
		for(int i=1; i<count; i*=2) {
			temp = top;
			while(temp.next!=null) {
				ListNode head1 = temp.next;
				ListNode head2 = null;
				ListNode buffer = temp;
				int j = 0;
				while(j<i*2&&temp.next!=null) {
					if(j==i) {
						head2 = temp.next;
						temp.next = null;
						temp = head2;
					}
					else temp = temp.next;
					j++;
				}
				ListNode next = temp.next;
				temp.next = null;
				//if(head1.val>head2.val) top.next = head2;
				while(head1!=null&&head2!=null) {
					if(head2.val>=head1.val) {
						if(head1.next==null) {
							head1.next = head2;
							break;
						} else if(head2.val>=head1.next.val)
							head1 = head1.next;
						else {
							buffer = head1.next;
							head1.next = head2;
							head1 = buffer;
						}
						//buffer = head1;
					} else {
						if(buffer!=null) buffer.next = head2;
						if(head2.next==null) {
							head2.next = head1;
							break;
						} else if(head1.val>head2.next.val) 
							head2 = head2.next;
						else {
							buffer = head2.next;
							head2.next = head1;
							head2 = buffer;
						}
					}
					buffer = null;
				}
				//System.out.println(head1);
				while(head1.next!=null) 
					head1 = head1.next;
				temp = head1;
				head1.next = next;
			}
			ListNode dd = top.next;
			count = 0;
			while(dd!=null) {
				count++;
				dd = dd.next;
			}
			System.out.println(count);
		}
		return top.next;
    }
	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(3);
		ListNode c = new ListNode(-20);
		ListNode d = new ListNode(-104);
		ListNode e = new ListNode(-100);
		ListNode f = new ListNode(8);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		int[] ddd = {-84,142,41,-17,-71,170,186,183,-21,-76,76,10,29,81,112,-39,-6,-43,58,41,111,33,69,97,-38,82,-44,-7,99,135,42,150,149,-21,-30,164,153,92,180,-61,99,-81,147,109,34,98,14,178,105,5,43,46,40,-37,23,16,123,-53,34,192,-73,94,39,96,115,88,-31,-96,106,131,64,189,-91,-34,-56,-22,105,104,22,-31,-43,90,96,65,-85,184,85,90,118,152,-31,161,22,104,-85,160,120,-31,144,115};
		ListNode ii = test(ddd);
		ListNode tt = sortList(ii);
		System.out.println(tt.val);
		int count = 0;
		while(tt!=null) {
			//System.out.println(tt.val);
			tt=tt.next;
			count++;
		}
		System.out.println(count);
	}
	static ListNode test(int[] a) {
		ListNode head = new ListNode(Integer.MIN_VALUE);
		ListNode temp = head;
		for(int i=0; i<a.length; ++i) {
			ListNode n = new ListNode(a[i]);
			temp.next = n;
			temp = n;
		}
		return head.next;
	}
}
