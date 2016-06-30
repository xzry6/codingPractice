package array;

public class ContainMostWater {
	public int maxArea(int[] height) {
		int start = 0;
		int end = height.length-1;
		int max = 0;
		int min;
		while(start<end){
			min = Math.min(height[start], height[end]);
			if((end-start)*min>max) max = (end-start)*min;
			if(height[start]>height[end]) end--;
			else start++;
		}
		return max;
	}
}
