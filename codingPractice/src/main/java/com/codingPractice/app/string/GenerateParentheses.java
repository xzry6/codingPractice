package com.codingPractice.app.string;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        recursive(list,n,0,new StringBuffer());
        return list;
    }
	
	private void recursive(List<String> list, int left, int right, StringBuffer sb) {
		if(left == 0 && right == 0) {
			list.add(sb.toString());
			return;
		}
		if(right != 0) {
			recursive(list,left,right-1,sb.append(')'));
			sb.deleteCharAt(sb.length()-1);
		}
		if(left != 0) {
			recursive(list,left-1,right+1,sb.append('('));
			sb.deleteCharAt(sb.length()-1);
		}
	}
	
	public static void main(String[] args) {
		List<String> list = new GenerateParentheses().generateParenthesis(1);
		for(String s:list)
			System.out.println(s);
	}
}
