package com.codingPractice.app.string;

/**
 * You are playing the following Flip Game with your friend:
 * Given a string that contains only these two characters: + and -,
 * you and your friend take turns to flip two consecutive "++" into "--".
 * The game ends when a person can no longer make a move and therefore
 * the other person will be the winner.
 * 
 * Write a function to determine if the starting player can guarantee a win.
 * 
 * For example, given s = "++++", return true.
 * The starting player can guarantee a win by flipping the middle "++" to become "+--+".
 * 
 * Follow up:
 * Derive your algorithm's runtime complexity.
 * 
 * 
 * @author Sean
 *
 */
public class FlipGameII {
	public static void main(String[] args) {
		String s = "+++++--";
		System.out.println(canWin(s));
	}

	public static boolean canWin(String s) {
        if(s == null || s.length() == 0) return false;
        if(s.indexOf("++") == -1) return false;

        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length - 1; ++ i) {
            if(arr[i] != '+' || arr[i + 1] != '+') continue;
            arr[i] = '-';
            arr[i + 1] = '-';
            if(!canWin(String.valueOf(arr))) return true;
            arr[i] = '+';
            arr[i + 1] = '+';
        }

        return false;
    }
}
