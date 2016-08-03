package com.codingPractice.app.string;

import java.util.ArrayList;
import java.util.List;

/**
 * You are playing the following Flip Game with your friend:
 * Given a string that contains only these two characters: + and -,
 * you and your friend take turns to flip two consecutive "++" into "--".
 * The game ends when a person can no longer make a move and therefore
 * the other person will be the winner.
 * 
 * Write a function to compute all possible states of the string after one valid move.
 * 
 * For example, given s = "++++", after one move, it may become one of the following states:
	[
	  "--++",
	  "+--+",
	  "++--"
	]
 * 
 * If there is no valid move, return an empty list [].
 * 
 * 
 * @author Sean
 *
 */
public class FlipGame {
	public List<String> generatePossibleNextMoves(String s) {
        List<String> list = new ArrayList<String>();
        if(s == null || s.length() == 0) return list;

        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length - 1; ++ i) {
            if(arr[i] != '+' || arr[i + 1] != '+') continue;
            arr[i] = '-';
            arr[i + 1] = '-';
            list.add(String.valueOf(arr));
            arr[i] = '+';
            arr[i + 1] = '+';
        }

        return list;
    }
}
