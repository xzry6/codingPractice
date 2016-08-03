package com.codingPractice.app.number;

/**
 * A strobogrammatic number is a number that looks
 * the same when rotated 180 degrees (looked at upside down).
 * 
 * Write a function to determine if a number is strobogrammatic.
 * The number is represented as a string.
 * For example, the numbers "69", "88", and "818" are all strobogrammatic.
 * 
 * @author Sean
 *
 */
public class StrobogrammaticNumber {
	public boolean isStrobogrammatic(String num) {
        if(num == null) return false;
        if(num.length() == 0) return true;

        char begin = num.charAt(0);
        if(num.length() == 1)
            return begin == '0'
                    || begin == '1'
                    || begin == '8';

        char end = num.charAt(num.length() - 1);
        if((begin == '0' && end == '0')
            || (begin == '1' && end == '1')
            || (begin == '8' && end == '8')
            || (begin == '6' && end == '9')
            || (begin == '9' && end == '6'))
            return isStrobogrammatic(num.substring(1, num.length() - 1));

        return false;
    }
}
