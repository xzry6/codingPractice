package com.codingPractice.app.dataStructure;

public class Rehashing {
	public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        if(hashTable == null || hashTable.length == 0) return hashTable;
        int size = hashTable.length*2;
        ListNode[] result = new ListNode[size];
        for(int i=0; i<hashTable.length; ++i) {
            ListNode node = hashTable[i];
            while(node != null) {
                int hash = (node.val%size+size)%size;
                if(result[hash] == null) result[hash] = new ListNode(node.val);
                else findEnd(result[hash]).next = new ListNode(node.val);
                node = node.next;
            }
        }
        return result;
    }
    
    private ListNode findEnd(ListNode node) {
        while(node.next != null) {
            node = node.next;
        }
        return node;
    }
    public static void main(String[] args) {
    		Rehashing r = new Rehashing();
    		ListNode[] l = new ListNode[3];
    		l[1] = new ListNode(29);
    		l[1].next = new ListNode(5);
    		r.rehashing(l);
    }
}
