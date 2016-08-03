package com.codingPractice.app.dataStructure;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {
	static HashMap<Integer,UndirectedGraphNode> hash;
	public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		hash = new HashMap<Integer,UndirectedGraphNode>();
        if(node==null) return null;
        return recursive(node);
    }
	public static UndirectedGraphNode recursive(UndirectedGraphNode node) {
		UndirectedGraphNode newnode = new UndirectedGraphNode(node.label);
		hash.put(newnode.label, newnode);
		for(int i=0; i<node.neighbors.size(); ++i) {
			UndirectedGraphNode p = node.neighbors.get(i);
			if(hash.containsKey(p.label)) newnode.neighbors.add(hash.get(p.label));
			else newnode.neighbors.add(recursive(p));
		}
		return newnode;
	}
	public static void main(String[] args) {
		UndirectedGraphNode node1 = new UndirectedGraphNode(0);
		UndirectedGraphNode node2 = new UndirectedGraphNode(0);
		UndirectedGraphNode node3 = new UndirectedGraphNode(0);
		node1.neighbors.add(node1);
		node1.neighbors.add(node1);
		cloneGraph2(node1);
		//System.out.println(node1.neighbors.get(i));
	}
	
	 public static UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
	        if(node == null) return null;
	        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
	        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
	        queue.add(node);
	        map.put(node, new UndirectedGraphNode(node.label));
	        while(!queue.isEmpty()) {
	            UndirectedGraphNode temp = queue.poll();
	            UndirectedGraphNode newNode = map.get(temp);
	            for(UndirectedGraphNode neighbor:temp.neighbors) {
	                if(!map.containsKey(neighbor)) {
	                    queue.add(neighbor);
	                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
	                }
	                newNode.neighbors.add(map.get(neighbor));
	            }
	        }
	        
	        return map.get(node);
	    }
}
