package number;

import java.util.LinkedList;

public class PalindromeNumber {
	public static boolean isPalindrome(int x) {
        LinkedList<Integer> ll = new LinkedList<Integer>();
        if(x<0) return false;
        if(x==0) return true;
		while(x!=0){
			ll.add(x%10);
			x/=10;
		}
		while(ll.size()>0){
			if(ll.getFirst()!=ll.getLast()) return false;
			else{
				ll.removeFirst();
				if(ll.size()!=0) ll.removeLast();
			}
		}
		return true;
    }
	
	public static void main(String[] args){
		System.out.println(isPalindrome(-2147447412));
	}
}
