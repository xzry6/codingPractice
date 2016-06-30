package dataStructure;

import java.util.HashMap;

public class CopyListwithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
		if(head==null) return null;
		HashMap<Integer, RandomListNode> hash = new HashMap<Integer, RandomListNode>();
        //List<RandomListNode> list = new ArrayList<RandomListNode>();
        RandomListNode point = head;
        RandomListNode node = new RandomListNode(Integer.MAX_VALUE);
        RandomListNode h = node;
        while(point!=null) {
        	RandomListNode next = new RandomListNode(point.label);
        	node.next = next;
        	hash.put(point.label, next);
        	point = point.next;
        	node = next;
        }
        point = head;
        while(point!=null) {
        	node = hash.get(point.label);
        	if(point.random!=null) node.random = hash.get(point.random.label);
        	point = point.next;
        }
        return h.next;
    }
}
