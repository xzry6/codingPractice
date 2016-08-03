 package com.codingPractice.app.pocketGemsCoding.example;

import java.util.HashSet;
import java.util.Set;

public class MonkeyGrid {

	Set<Point> set = new HashSet<Point>();

	public static void main(String[] args) {
		MonkeyGrid mg = new MonkeyGrid();
		System.out.println(mg.accessiblePoints());
	}

	private int accessiblePoints() {
		Point top = new Point(0, 0);
		return recursive(top) * 4;
	}

	private int recursive(Point p) {
		if(p.x < 0 || p.y < 0) return 0;

		int value = calculateValue(p);
		if(value >= 19) return 0;
		if(set.contains(p)) return 0;

		set.add(p);
		Point left = new Point(p.x - 1, p.y);
		Point right = new Point(p.x + 1, p.y);
		Point up = new Point(p.x, p.y - 1);
		Point down = new Point(p.x, p.y + 1);

		return recursive(left)
			 + recursive(right)
			 + recursive(up)
			 + recursive(down)
			 + 1;
	}

	private int calculateValue(Point p) {
		int x = p.x;
		int y = p.y;

		int sum = 0;
		while(x != 0) {
			sum += x % 10;
			x /= 10;
		}
		while(y != 0) {
			sum += y % 10;
			y /= 10;
		}

		return sum;
	}

	private class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object obj) {
			if(!(obj instanceof Point)) {
				return false;
			}
			Point p = (Point) obj;
			return p.x == this.x && p.y == this.y; 
		}

		@Override
		public int hashCode() {
		    return 31 * x + y;
		}
	}
}
