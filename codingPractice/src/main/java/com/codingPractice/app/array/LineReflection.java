package com.codingPractice.app.array;

import java.util.HashSet;
import java.util.Set;

public class LineReflection {

	public static void main(String[] args) {
		LineReflection lr = new LineReflection();
		int[][] points = {{0, 0}, {1, 0}};
		System.out.println(lr.isReflected(points));
	}

	class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return 31*x + y;
        }

        @Override
        public boolean equals(Object obj) {
            if(!(obj instanceof Point)) return false;
            Point p = (Point) obj;
            return p.x == this.x && p.y == this.y;
        }
    }

    /**
     * Method.
     */
    public boolean isReflected(int[][] points) {
        if(points == null || points.length == 0 || points[0].length == 0) return true;

        Set<Point> set = new HashSet<Point>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int[] point:points) {
            max = Math.max(max, point[0]);
            min = Math.min(min, point[0]);
            set.add(new Point(point[0], point[1]));
        }

        int sum = max + min;
        for(int[] point:points)
            if(!set.contains(new Point(sum - point[0], point[1]))) return false;
        return true;
    }
}
