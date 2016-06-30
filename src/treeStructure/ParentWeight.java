package treeStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Question: You are given a CSV file with 3 columns -- all integers: 
 *
 * id,parent,weight 
 * 10,30,1 
 * 30,0,10 
 * 20,30,2 
 * 50,40,3 
 * 40,30,4 
 *
 * 0 is the assumed root node with weight 0 
 *
 * which describes a tree-like structure 
 * -- each line is a node, 'parent' refers to 'id' of another node. 
 *
 * Print out, for each node, the total weight of a subtree below this node (by convention, the weight of a subtree for node X includes the own weight of X). 
 *
 * You may assume that the input comes pre-parsed as a sequence of Node objects 
 * 
 * @author Sean
 *
 */
public class ParentWeight {
	
	static class Node {
		int id; 
		int parent; 
		int weight; 
		int total;
		
		Node(int id, int parent, int weight) {
			this.id = id;
			this.parent = parent;
			this.weight = weight;
			this.total = 0;
		}
	}
	
	public static void printSubTreeWeight(List<Node> nodes) { 
		Map<Integer, Node> map = new HashMap<Integer, Node>();
		Node top = new Node(0, 0, 0);
		map.put(0, top);
		
		for(Node node:nodes) {
			map.put(node.id, node);
		}
		for(Node node:nodes) {
			Node tmp = node;
			while(tmp.id != 0) {
				tmp.total += node.weight;
				tmp = map.get(tmp.parent);
			}
		}
		for(Node node:nodes) {
			System.out.println(node.id+": "+node.total);
		}
	}
	
	public static void main(String[] args) {
//		Node n1 = new Node(10, 30, 1);
//		Node n2 = new Node(30, 0, 10);
//		Node n3 = new Node(20, 30, 2);
//		Node n4 = new Node(50, 40, 3);
//		Node n5 = new Node(40, 30, 4);
//		List<Node> list = new ArrayList<Node>();
//		list.add(n1);
//		list.add(n2);
//		list.add(n3);
//		list.add(n4);
//		list.add(n5);
//		printSubTreeWeight(list);
		
		String s = "lkajfioejlwjflasl";
		byte[] b = s.getBytes();
		System.out.println((int) 'l');
		System.out.println(s.length());
		System.out.println(b.length);
		System.out.println(Arrays.toString(b));
	}
}
