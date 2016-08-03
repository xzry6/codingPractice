package com.codingPractice.app.dataStructure;

import java.util.ArrayList;
import java.util.List;

public class MergeKSortedLists {
	public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        if(lists == null || lists.size() == 0) return null;
        return binary(lists, 0, lists.size()-1);
    }
    
    private ListNode merge(ListNode n1, ListNode n2) {
        ListNode top = new ListNode(-1);
        ListNode node = top;
        while(n1 != null && n2 != null) {
            if(n1.val < n2.val) {
                node.next = n1;
                n1 = n1.next;
            }
            else {
            		node.next = n2;
            		n2 = n2.next;
            }
            node = node.next;
        }
        if(n1 == null) node.next = n2;
        if(n2 == null) node.next = n1;
        return top.next;
    }
    
    private ListNode binary(List<ListNode> lists, int begin, int end) {
        if(begin > end) return null;
        if(begin == end) return lists.get(begin);
        ListNode left = binary(lists, begin, (begin+end)/2);
        ListNode right = binary(lists, (begin+end)/2+1, end);
        return merge(left, right);
    }
    
    public static void main(String[] args) {
    		List<ListNode> list = new ArrayList<ListNode>();
    		ListNode n1 = new ListNode(1);
    		list.add(n1);
    		ListNode n2 = new ListNode(2);
    		list.add(null);
    		list.add(n2);
    		ListNode result = new MergeKSortedLists().mergeKLists(list);
    		while(result != null) {
    			System.out.println(result.val);
    			result = result.next;
    		}
    }
}
