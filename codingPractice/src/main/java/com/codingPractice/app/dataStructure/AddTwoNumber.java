package com.codingPractice.app.dataStructure;

public class AddTwoNumber {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int[] val = new int[2];
		ListNode root = new ListNode(0);
		ListNode node = root;
		while(l1!=null&&l2!=null){
			judge(l1.val,l2.val,val);
			ListNode newNode = new ListNode(val[1]);
			node.next = newNode;
			node = node.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		if(l1==null&&l2!=null){
			node.next = l2;
			while(l2!=null){
				judge(0,l2.val,val);
				l2.val = val[1];
				node = l2;
				l2 = l2.next;
			}
		}
		if(l1!=null&&l2==null){
			node.next = l1;
			while(l1!=null){
				judge(0,l1.val,val);
				l1.val = val[1];
				node = l1;
				l1 = l1.next;
			}
		}
		if(val[0]==1){
			ListNode newNode = new ListNode(1);
			node.next = newNode;
		}
		return root.next;
    }
	static void judge(int val1, int val2, int[] value){
		if(value[0]==1) value[1] = val1+val2+1;
		else value[1] = val1+val2;
		if(value[1]>=10){
			value[1] = value[1]-10;
			value[0] = 1;
		}
		else value[0] = 0;
	}
	public static void main(String[] args){
		ListNode l1 = new ListNode(9);
		ListNode l = new ListNode(8);
		l1.next = l;
		ListNode l2 = new ListNode(1);
		ListNode output = addTwoNumbers(l1,l2);
		System.out.println(output.val);
		System.out.println(output.next.val);
	}
}
