package com.codingPractice.app.string;

import java.util.Stack;

public class BasicCalculator {
	public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sub = new StringBuilder();
		int sum = 0;
		int symbol = '+';
		for(int i=0; i<s.length(); ++i) {
			char c = s.charAt(i);
			if(Character.isDigit(c)) {
				sub.append(c);
				continue;
			}
			if(c == '+' || c == '-') {
				sum += regularize(sub, symbol);
				sub = new StringBuilder();
				symbol = c;
				continue;
			}
			if(c == '(') {
				stack.push(sum);
				stack.push(symbol);
				sum = 0;
				symbol = '+';
				continue;
			}
			if(c == ')') {
				sum += regularize(sub, symbol);
				sub = new StringBuilder();
				symbol = stack.pop();
				int pre = stack.pop();
				sum = regularize(sum, pre, symbol);
				continue;
			}
		}
		if(sub.length() != 0) sum += regularize(sub, symbol);
		return sum;
    }
	
	private int regularize(StringBuilder sb, int symbol) {
		if(sb.length() == 0) return 0;
		int temp = Integer.parseInt(sb.toString());
		if(symbol == '-') return -temp;
		return temp;
	}
	
	private int regularize(int sum, int pre, int symbol) {
		if(symbol == '+')
			sum = pre+sum;
		else if(symbol == '-')
			sum = pre-sum;
	    return sum;
	}
	
	public static void main(String[] args) {
//		BasicCalculator bc = new BasicCalculator();
//		System.out.println(bc.calculate("1-(5)"));
		System.out.println('9'-48);
	}
}
