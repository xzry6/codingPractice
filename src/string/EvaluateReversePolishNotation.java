package string;

import java.util.Stack;

public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		if(tokens.length==0) return -1;
        Stack<Integer> s = new Stack<Integer>();
        int length = tokens.length;
        for(int i=0; i<length; ++i) {
        	int temp = 0;
        	int i1 = 0;
        	int i2 = 0;
        	switch(tokens[i]) {
        	case "+":
        		i1 = s.pop();
        		i2 = s.pop();
        		temp = i2+i1;
        		break;
        	case "-":
        		i1 = s.pop();
        		i2 = s.pop();
        		temp = i2-i1;
        		break;
        	case "*":
        		i1 = s.pop();
        		i2 = s.pop();
        		temp = i2*i1;
        		break;
        	case "/":
        		i1 = s.pop();
        		i2 = s.pop();
        		temp = i2/i1;
        		break;
        	default: temp = Integer.parseInt(tokens[i]);
        	}
        	s.push(temp);
        }
        return s.pop();
    }
}
