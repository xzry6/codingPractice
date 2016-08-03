package com.codingPractice.app.string;

public class ValidNumber {
	public boolean isNumber(String s) {
		s = s.trim();
        if(s == null || s.length() ==0) return false;
        
        boolean preNum = false;
        boolean postNum = false;
        boolean dot = false;
        boolean e = false;
        for(int i=0; i<s.length(); ++i) {
            char c = s.charAt(i);
            if(c == '-' || c == '+') {
                if(i != 0 && s.charAt(i-1) != 'e')
                    return false;
            }
            else if(Character.isDigit(c)) {
                preNum = true;
                postNum = true;
            }
            else if(c == 'e') {
                if(e || !preNum) return false;
                postNum = false;
                e = true;
            }
            else if(c == '.') {
                if(dot || e) return false;
                dot = true;
            }
            else return false;
        }
        return preNum && postNum;
    }
	public static void main(String[] args) {
		ValidNumber vn = new ValidNumber();
		System.out.println(vn.isNumber("-1."));
	}
}
