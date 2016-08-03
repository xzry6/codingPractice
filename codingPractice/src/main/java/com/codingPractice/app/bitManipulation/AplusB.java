package com.codingPractice.app.bitManipulation;

public class AplusB {
	public int aplusb(int a, int b) {
        // write your code here, try to do it without arithmetic operators.
        int carry = 0;
        int result = 0;
        for(int i=0; i<32; ++i) {
            int a0 = a & 1;
            int b0 = b & 1;
            result |= (a0 ^ b0 ^ carry) << i;
            if(carry == 0)
                carry = a0 & b0;
            else carry = a0 | b0; 
            a = a >> 1;
            b = b >> 1;
        }
        return result;
    }
	
	public static void main(String[] args) {
		System.out.println(new AplusB().aplusb(1, 2));
	}
}
