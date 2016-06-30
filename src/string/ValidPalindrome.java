package string;

public class ValidPalindrome {
	public static boolean isPalindrome(String s) {
		if(s.length()==0) return true;
        int begin = 0;
        int end = s.length()-1;
        do {
        	char b = Character.toLowerCase(s.charAt(begin));
        	if(!Character.isLetterOrDigit(b)) {
        		begin++;
        		continue;
        	}
        	char e = Character.toLowerCase(s.charAt(end));
        	if(!Character.isLetterOrDigit(e)) {
        		end--;
        		continue;
        	}
        	if(b!=e) return false;
        	begin++;
        	end--;
        } while(begin<=end);
        return true;
    }
	
	
	public static void main(String[] args) {
		String s = "ab2a";
		
		System.out.println(isPalindrome(s));
	}
}
