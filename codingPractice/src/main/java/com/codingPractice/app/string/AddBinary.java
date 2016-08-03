package com.codingPractice.app.string;

public class AddBinary {
	public String addBinary(String a, String b) {
		if(a.length()==0&&b.length()==0) return new String();
		StringBuilder c = new StringBuilder();
        int max = Math.max(a.length(), b.length());
        int point = 0;
        boolean bool = false;
        while(point<max) {
        	int A = 0;
        	int B = 0;
        	if(point<a.length()) A = Character.getNumericValue(a.charAt(a.length()-1-point));
        	if(point<b.length()) B = Character.getNumericValue(b.charAt(b.length()-1-point));
        	int up = A+B;
        	if(bool) up++;
    		if(up>1) bool = true;
    		else bool = false;
    		c.append(up%2);
    		point++;
        }
        if(bool) c = c.append(1);
        return c.reverse().toString();
    }
}
