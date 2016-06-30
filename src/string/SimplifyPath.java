package string;

import java.util.Stack;

public class SimplifyPath {
	public static String simplifyPath(String path) {
		Stack<String> stack = new Stack<String>();
		String result = new String();
		int index = 0;
		while(index<path.length()) {
			if(path.charAt(index)=='/') {
				index++;
				continue;
			}
			if(!path.substring(index).contains("/")) {
				if(path.substring(index).equals("..")) {
					if(!stack.isEmpty())
						stack.pop();
				}
				else if(!path.substring(index).equals("."))
					stack.push(path.substring(index));
				break;
			}
			int p = path.substring(index).indexOf('/');
			String temp = path.substring(index, index+p);
			if(!temp.equals(".")&&!temp.equals("..")) {
				stack.push(temp);
			}
			if(temp.equals("..")) {
				if(!stack.isEmpty()) 
					stack.pop();
			}
			index = index+p;
		}
		while(!stack.isEmpty()) {
			String temp = stack.pop();
			result = '/'+temp+result;
		}
		if(result.length()==0) return "/";
		return result;
    }
	public static void main(String[] args) {
		System.out.println(simplifyPath("/.."));
	}
}
