package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * A city's skyline is the outer contour of the silhouette
 * formed by all the buildings in that city when viewed from a distance.
 * Now suppose you are given the locations and height of all the buildings
 * as shown on a cityscape photo (Figure A), write a program to output the
 * skyline formed by these buildings collectively (Figure B).
 * 
 * 
 * The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi],
 * where Li and Ri are the x coordinates of the left and right edge of the ith building,
 * respectively, and Hi is its height.
 * 
 * It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0.
 * You may assume all buildings are perfect rectangles
 * grounded on an absolutely flat surface at height 0.
 * 
 * For instance, the dimensions of all buildings in Figure A are recorded as:
 * [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ].
 * 
 * The output is a list of "key points" (red dots in Figure B) in the format of
 * [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline.
 * A key point is the left endpoint of a horizontal line segment.
 * Note that the last key point, where the rightmost building ends,
 * is merely used to mark the termination of the skyline, and always has zero height.
 * Also, the ground in between any two adjacent buildings should be considered
 * part of the skyline contour.
 * 
 * For instance, the skyline in Figure B should be represented as:
 * [ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].
 * 
 * Notes:
 * - The number of buildings in any input list is guaranteed to be in the range [0, 10000].
 * - The input list is already sorted in ascending order by the left x position Li.
 * - The output list must be sorted by the x position.
 * - There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]
 * 
 * @author Sean
 *
 */
public class TheSkylineProblem {

	public static void main(String[] args) {
		TheSkylineProblem slp = new TheSkylineProblem();
		int[][] buildings = {
				{1, 2, 1},
				{1, 2, 2},
				{1, 2, 3}
//				{0, 3, 3},
//				{1, 5, 3},
//				{2, 4, 3},
//				{3, 7, 3}
//				{2, 9, 10},
//				{3, 7, 15},
//				{5, 12, 12},
//				{15, 20, 10},
//				{19, 24, 8}
		};
		List<int[]> list = slp.getSkyline(buildings);
		for(int[] interval:list)
			System.out.println(Arrays.toString(interval));
	}

	private Comparator<int[]> c1 = new Comparator<int[]>() {
		@Override
		public int compare(int[] i1, int[] i2) {
			return i1[1] - i2[1];
		}
	};

	private Comparator<Integer> c2 = new Comparator<Integer>() {
		@Override
		public int compare(Integer i1, Integer i2) {
			return i2.intValue() - i1.intValue();
		}
	};

	public List<int[]> getSkyline(int[][] buildings) {
		List<int[]> list = new ArrayList<int[]>();

		if(buildings == null
			|| buildings.length == 0
			|| buildings[0].length == 0)
			return list;

		Queue<int[]> endings = new PriorityQueue<int[]>(c1);
		Queue<Integer> heights = new PriorityQueue<Integer>(c2);

		for(int[] building:buildings) {
			while(!endings.isEmpty() && endings.peek()[1] < building[0]) {
				int[] ending = endings.poll();
				heights.remove(ending[2]);
				
				int[] arr = {ending[1], heights.isEmpty() ? 0 : heights.peek()};
				list.add(arr);
 			}
			endings.offer(building);
			heights.offer(building[2]);
			int[] arr = {building[0], heights.peek()};
			list.add(arr);
		}

		while(!endings.isEmpty()) {
			int[] ending = endings.poll();
			heights.remove(ending[2]);
			int[] arr = {ending[1], heights.isEmpty() ? 0 : heights.peek()};
			list.add(arr);
		}

		for(int i = 0; i < list.size(); ++ i) {
			if(i != list.size() - 1) {
				if(list.get(i)[0] == list.get(i + 1)[0])
					list.remove(i--);
				else if(list.get(i)[1] == list.get(i + 1)[1])
					list.remove(i-- + 1);
			}
		}
		return list;
    }
}
