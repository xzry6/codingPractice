package array;

import java.util.Arrays;
import java.util.Stack;


public class RemoveDuplicatesfromSortedArrayII {
	public static int removeDuplicates(int[] A) {
		if(A.length==0) return 0;
		Stack<Integer> stack = new Stack<Integer>();
		boolean bool = false;
        for(int i=0; i<A.length; ++i) {
        	if(!stack.isEmpty()&&stack.peek()==A[i]) {
        		if(bool) continue;
        		else {
        			stack.push(A[i]);
        			bool = true;
        		}
        	}
        	else {
        		stack.push(A[i]);
        		bool = false;
        	}
        }
        int total = stack.size();
        for(int i=total-1; i>-1; --i) {
        	A[i] = stack.pop();
        }
        return total;
    }
	public static void main(String[] args) {
		int[] A = {1,1,1,2,3};
		int a = removeDuplicates(A);
		System.out.println(a);
		System.out.println(Arrays.toString(A));
	}
}
