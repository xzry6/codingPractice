package com.codingPractice.app.pocketGemsCoding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DirectedGraph {

	// Given a graph list, return all the paths of the graph
	public List<String> allPath(List<String> list) {
		// Initialize an empty list first
		List<String> paths = new ArrayList<String>();
		// Return the empty list if graph list is empty
		if(list == null || list.size() == 0) return paths;
		// Get the beginning point and destination of the graph
		char[] info = list.remove(0).toCharArray();
		char start = info[0];
		char end = info[info.length-1];
		// Parse the graph list to a linked map
		Map<Character, List<Character>> map = parse(list);
		// Create a hash set for recording passed states
		Set<Character> set = new HashSet<Character>();
		// Backtrack and add path to the 	paths list
		backtrack(start+"", end, set, map, paths);
		// Return paths list
		return paths;
	}

	// Parse a list, return a linked map
	private Map<Character, List<Character>> parse(List<String> list) {
		Map<Character, List<Character>> map = new HashMap<Character, List<Character>>();
		for(String string: list) {
			String[] strArr = string.trim().split(":");
			List<Character> charList = new ArrayList<Character>();
			char[] charArr = strArr[1].toCharArray();
			for(char c: charArr) {
				if(c == ' ') continue;
				charList.add(c);
			}
			map.put(strArr[0].charAt(0), charList);
		}
 		return map;
	}

	// Backtrack and create the paths list
	private void backtrack(String currentPath,
						  char destination,
						  Set<Character> set,
						  Map<Character, List<Character>> map,
						  List<String> paths) {
		char currentState = currentPath.charAt(currentPath.length()-1);
		// Return if reach at destination
		if(currentState == destination) {
			paths.add(currentPath);
			return;
		}
		// Get the neighbors from map
		List<Character> neighbors = map.get(currentState);
		for(char neighbor: neighbors) {
			// Continue if already been the state
			if(set.contains(neighbor)) { continue; }
			// Add to current path and recursive if never been the state
			currentPath += neighbor;
			set.add(neighbor);
			backtrack(currentPath, destination, set, map, paths);
			// Remove status when finished
			currentPath = currentPath.substring(0, currentPath.length()-1);
			set.remove(neighbor);
		}
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("A E");
		list.add("A: B C D");
		list.add("B: C");
		list.add("C: E");
		list.add("D: B");
		DirectedGraph dg = new DirectedGraph();
		List<String> paths = dg.allPath(list);
		for(String path: paths) {
			System.out.println(path);
		}
	}
}
