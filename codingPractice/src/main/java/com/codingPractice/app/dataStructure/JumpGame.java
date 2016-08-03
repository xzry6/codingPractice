package com.codingPractice.app.dataStructure;

import java.util.ArrayList;
import java.util.List;

public class JumpGame {
	public static boolean canJump(List<Integer> nums) {
        int scale = 1;
        for(int i=nums.size()-2; i>=0; --i) {
        	int temp = nums.get(i);
        	if(temp>=scale) 
        		scale = 1;
        	else scale++;
        }
        if(scale==1) return true;
        return false;
    }
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(3);
		list.add(1);
		list.add(0);
		list.add(4);
		System.out.println(canJump(list));
		
		
		
	}
}
