package com.codingPractice.app.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A 2d grid map of m rows and n columns is initially filled with water.
 * We may perform an addLand operation which turns the water at
 * position (row, col) into a land. Given a list of positions to operate,
 * count the number of islands after each addLand operation.
 * An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * 
 * Example:
 * 
 * Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]]
 * Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).

	0 0 0
	0 0 0
	0 0 0
	Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.

	1 0 0
	0 0 0   Number of islands = 1
	0 0 0
	Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.

	1 1 0
	0 0 0   Number of islands = 1
	0 0 0
	Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.
	
	1 1 0
	0 0 1   Number of islands = 2
	0 0 0
	Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.

	1 1 0
	0 0 1   Number of islands = 3
	0 1 0
	We return the result as an array: [1, 1, 2, 3]

 * Challenge:
 * Can you do it in time complexity O(k log mn),
 * where k is the length of the positions?
 * 
 * @author Sean
 *
 */
public class NumberOfIslandsII {

	public static void main(String[] args) {
		int[][] positions = {{0, 0}, {0, 1}, {1, 2}, {2, 2}, {0, 2}, {2, 1}};
		List<Integer> list = numIslands2(3, 3, positions);
		for(int i:list) System.out.println(i);
	}

	public static List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> list = new ArrayList<Integer>();
        if(m == 0 || n == 0) return list;
        	if(positions == null || positions.length == 0 || positions[0].length == 0) return list;

        	int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        	int[] cached = new int[m * n];
        	Arrays.fill(cached, -1);
        	int count = 0;

        	for(int[] position:positions) {
        		int index = n * position[0] + position[1];
        		cached[index] = index;
        		count ++;

        		for(int[] direction:directions) {
        			int i = position[0] + direction[0];
        			int j = position[1] + direction[1];
        			int neighbor = n * i + j;
        			if(i < 0 || j < 0 || i >= m || j >= n || cached[neighbor] == -1) continue;
        			while(cached[neighbor] != neighbor) neighbor = cached[neighbor];
        			if(neighbor != index) {
        				cached[index] = neighbor;
        				index = neighbor;
        				count --;
        			}
        		}

        		list.add(count);
        	}
        	return list;
    }
}
