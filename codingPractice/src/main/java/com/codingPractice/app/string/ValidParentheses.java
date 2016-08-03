package com.codingPractice.app.string;

import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
		if(s.length() == 0) return true;
        if(s.length()%2 == 1) return false;
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i<s.length(); ++i) {
        		char c = s.charAt(i);
        		if(stack.isEmpty() || !match(c,stack.peek())) stack.push(c);
        		else stack.pop();
        }
        return stack.isEmpty();
    }
	
	private boolean match(char c, char obj) {
		if(obj == '(' && c == ')' ||
				obj == '[' && c ==']' ||
				obj == '{' && c =='}')
			return true;
		return false;
		
	}
	
	
	public static void main(String[] args) {
		System.out.println((int)'(');
		System.out.println((int)')');
		System.out.println((int)'[');
		System.out.println((int)']');
		System.out.println((int)'{');
		System.out.println((int)'}');
		
	}
}
