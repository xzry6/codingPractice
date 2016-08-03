package com.codingPractice.app.string;

import java.util.Stack;

public class BasicCalculatorII {
	public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int sum = 1;
        int temp = 0;
        int sig = '*';
        for(int i=0; i<s.length(); ++i) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) temp = 10*temp+(c-48);
            else if(c == '/' || c == '*') {
                if(sig != '*' && sig != '/' && stack.isEmpty()) {
                    stack.push(sum);
                    stack.push(sig);
                    sum = temp;
                } else 
                    sum = operate(sum, temp, sig);
                sig = c;
                temp = 0;
            } else if(c == '+' || c == '-') {
                sum = operate(sum, temp, sig);
                if(!stack.isEmpty()) {
                    sig = stack.pop();
                    temp = stack.pop();
                    sum = operate(temp, sum, sig);
                }
                sig = c;
                temp = 0;
            }
        }
        sum = operate(sum, temp, sig);
        if(!stack.isEmpty()) {
            sig = stack.pop();
            temp = stack.pop();
            sum = operate(temp, sum, sig);
        }
        return sum;
    }
    
    private int operate(int a, int b, int operater) {
        switch(operater) {
            case '*': return a*b;
            case '/': return a/b;
            case '-': return a-b;
            default: return a+b;
        }
    }
    public static void main(String[] args) {
    		BasicCalculatorII bc2 = new BasicCalculatorII();
    		System.out.println(bc2.calculate2("1-1+1"));
    }
    
    public int calculate2(String s) {
        // Deal with null and empty value first.
        if(s == null || s.length() == 0) return -1;
        // Have a stack storing numbers.
        Stack<String> stack = new Stack<String>();
        // Have a string storing local number string.
        String num = "";
        // Begin the loop.
        for(int i=s.length()-1; i>=0; --i) {
            char c = s.charAt(i);
            if(c == ' ') continue;
            if(Character.isDigit(c)) num = c+num;
            else {
                if(c == '+') {
                    calculate(stack, num, 1);
                } else if(c == '-') {
                		calculate(stack, num, -1);
                }
                else if(c == '*' || c == '/' ) {
                    stack.push(num);
                }
                stack.push(Character.toString(c));
                num = "";
            }
        }
        calculate(stack, num, 1);
        // Return result.
        return Integer.parseInt(stack.pop());
    }

    // Have a function calculating stack.
    private void calculate(Stack<String> stack, String num, int pre) {
        int sum = Integer.parseInt(num);
        while(!stack.isEmpty()) {
            String operator = stack.pop();
            int temp = Integer.parseInt(stack.pop());
            switch(operator) {
                case "+":
                    sum += pre*temp;
                    break;
                case "-":
                    sum -= pre*temp;
                    break;
                case "*":
                    sum *= temp;
                    break;
                case "/":
                    sum /= temp;
                    break;
            }
        }
        stack.push(Integer.toString(sum));
    }
}
