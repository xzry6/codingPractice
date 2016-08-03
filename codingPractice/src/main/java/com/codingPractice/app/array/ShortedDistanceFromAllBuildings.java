package com.codingPractice.app.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortedDistanceFromAllBuildings {
	public static void main(String[] args) {
		ShortedDistanceFromAllBuildings s = new ShortedDistanceFromAllBuildings();
		int[][] grid = {{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}};
		System.out.println(s.shortestDistance(grid));
	}
	private class Point {
        int i;
        int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }


    public int shortestDistance(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        List<Point> list = new ArrayList<Point>();
        for(int i = 0; i < grid.length; ++ i) {
            for(int j = 0; j < grid[i].length; ++ j) {
                if(grid[i][j] == 1) list.add(new Point(i, j));
            }
        }

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[][] distance = new int[grid.length][grid[0].length];
        for(int i = 0; i < list.size(); ++ i) {
            Queue<Point> queue = new LinkedList<Point>();
            queue.offer(list.get(i));
            int dis = 0;
            while(!queue.isEmpty()) {
                int size = queue.size();
                for(int k = 0; k < size; ++ k) {
                    Point tmp = queue.poll();
                    distance[tmp.i][tmp.j] += dis;
                    for(int[] direction:directions) {
                        int x = tmp.j + direction[1];
                        int y = tmp.i + direction[0];
                        if(x >= 0 && x < grid[0].length && y >= 0 && y < grid.length && grid[y][x] == -i) {
                            grid[y][x] --;
                            queue.offer(new Point(y, x));
                        }
                    }
                }
                dis ++;
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < grid.length; ++ i)
            for(int j = 0; j < grid[i].length; ++ j)
                if(distance[i][j] != 0 && grid[i][j] == -list.size()) min = Math.min(min, distance[i][j]);
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
