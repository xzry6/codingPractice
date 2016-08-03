package com.codingPractice.app.array;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
	
	public static int[] twoSum(int[] number, int target){
		int[] index = new int[2];
		int num;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<number.length; ++i){
			num = number[i];
			if(map.containsKey(target-num)){
				index[0] = map.get(target-num)+1;
				index[1] = i+1;
			}
			map.put(num, i);
		}
		return index;
	}
	public static int[] twoSum1(int[] numbers, int target){
		int[] sortedArray = new int[numbers.length];
		int[] index = new int[2];
		index[1] = numbers.length-1;
		System.arraycopy(numbers, 0, sortedArray, 0, numbers.length);
		Arrays.sort(sortedArray);
		int num1, num2;
		boolean flag = false;
		do{
			num1 = sortedArray[index[0]];
			num2 = sortedArray[index[1]];
			if(num1+num2>target) index[1]--;
			else if(num1+num2<target) index[0]++;
			if(index[1]<index[0]) return null;
		} while(num1+num2!=target);
		for(int i=0; i<numbers.length; ++i){
			if(numbers[i]==num1&&!flag){
				index[0] = i+1;
				flag = true;
			}
			if(numbers[i]==num2) index[1] = i+1;
		}
		Arrays.sort(index);
		return index;
	}
	
	public static void main(String[] args){
		int[] number = {0,4,3,0};
		int target = 0;
		int[] index = twoSum(number, target);
		int[] index1 = twoSum1(number, target);
		System.out.println("index1="+index[0]+", index2="+index[1]);
		System.out.println("index1="+index1[0]+", index2="+index1[1]);
	}
}
