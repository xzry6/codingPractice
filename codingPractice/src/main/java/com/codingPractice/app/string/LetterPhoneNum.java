package com.codingPractice.app.string;

import java.util.ArrayList;
import java.util.List;

public class LetterPhoneNum {
	public static List<String> letterCombinations(String digits) {
		String[] map = {" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		List<String> list = new ArrayList<String>();
		String temp = "";
		recursive(list,map,digits,temp,0);
		
		return list;
    }
	
	static void recursive(List<String> list, String[] map, String digits, String temp, int index){
		if(index==digits.length()){
			list.add(temp);
			return;
		}
		int num = (int) digits.charAt(index)-48;
		for(int i=0; i<map[num].length(); ++i){
			recursive(list,map,digits,temp+map[num].charAt(i),index+1);
		}
	}
	
	public static void main(String[] args){
		List<String> list = letterCombinations("1");
		for(int i=0; i<list.size(); ++i){
			System.out.println(list.get(i));
		}
	}
}
