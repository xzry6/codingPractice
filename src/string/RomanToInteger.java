package string;

public class RomanToInteger {
	static int dic(char c){
		switch(c){
		case 'I': return 1;
		case 'V': return 5;
		case 'X': return 10;
		case 'L': return 50;
		case 'C': return 100;
		case 'D': return 500;
		case 'M': return 1000;
		 default: return 0;
		}
	}
	public static int romanToInt(String s) {
		char[] c = s.toCharArray();
		int temp = 0;
		int total = 0;
		for(int i=c.length-1; i>-1; --i){
			int next = dic(c[i]);
			if(next<temp) total -= next;
			else total += next;
			temp = next;
		}
		return total;
    }
	public static void main(String[] args){
		System.out.println(romanToInt("DCXXI"));
	}
}
