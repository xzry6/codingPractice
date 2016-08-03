package com.codingPractice.app.array;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given a m x n 2D grid initialized with these three possible values.
 * 
 * -1 - A wall or an obstacle.
 * 0 - A gate.
 * INF - Infinity means an empty room.
 *       We use the value 231 - 1 = 2147483647 to
 *       represent INF as you may assume that the
 *       distance to a gate is less than 2147483647.
 *       
 * Fill each empty room with the distance to its nearest gate.
 * If it is impossible to reach a gate, it should be filled with INF.
 * 
 * For example, given the 2D grid:
	INF  -1  0  INF
	INF INF INF  -1
	INF  -1 INF  -1
	  0  -1 INF INF

 * After running your function, the 2D grid should be:
	  3  -1   0   1
	  2   2   1  -1
	  1  -1   2  -1
	  0  -1   3   4
 * 
 * @author Sean
 *
 */
public class WallsAndGates {
	private class Coordinate {
        int i;
        int j;
        int dis;

        public Coordinate(int i, int j, int dis) {
            this.i = i;
            this.j = j;
            this.dis = dis;
        }
    }

    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0) return;

        Queue<Coordinate> queue = new LinkedList<Coordinate>();
        for(int i = 0; i < rooms.length; ++ i)
            for(int j = 0; j < rooms[i].length; ++ j)
                if(rooms[i][j] == 0) queue.add(new Coordinate(i, j, 0));

        while(!queue.isEmpty()) {
            Coordinate tmp = queue.poll();
            if(rooms[tmp.i][tmp.j] < 0) continue;

            if(tmp.i > 0 && rooms[tmp.i - 1][tmp.j] == Integer.MAX_VALUE) {
            		rooms[tmp.i - 1][tmp.j] = rooms[tmp.i][tmp.j] + 1;
            		queue.offer(new Coordinate(tmp.i - 1, tmp.j, tmp.dis + 1));
            }
                
            if(tmp.j > 0 && rooms[tmp.i][tmp.j - 1] == Integer.MAX_VALUE) {
            		rooms[tmp.i][tmp.j - 1] = rooms[tmp.i][tmp.j] + 1;
                queue.offer(new Coordinate(tmp.i, tmp.j - 1, tmp.dis + 1));
            }
            if(tmp.i < rooms.length - 1 && rooms[tmp.i + 1][tmp.j] == Integer.MAX_VALUE) {
            		rooms[tmp.i + 1][tmp.j] = rooms[tmp.i][tmp.j] + 1;
                queue.offer(new Coordinate(tmp.i + 1, tmp.j, tmp.dis + 1));
            }
            if(tmp.j < rooms[0].length - 1 && rooms[tmp.i][tmp.j + 1] == Integer.MAX_VALUE) {
            		rooms[tmp.i][tmp.j + 1] = rooms[tmp.i][tmp.j] + 1;
                queue.offer(new Coordinate(tmp.i, tmp.j + 1, tmp.dis + 1));
            }
        }
    }
}
