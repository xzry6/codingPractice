package com.codingPractice.app.systemDesign;

/**
 * 
 * Design a Tic-tac-toe game that is played between two players on a n x n grid.
 * You may assume the following rules:
 * A move is guaranteed to be valid and is placed on an empty block.
 * Once a winning condition is reached, no more moves is allowed.
 * A player who succeeds in placing n of their marks in a horizontal, vertical,
 * or diagonal row wins the game.
 * 
 * Example:
 * Given n = 3, assume that player 1 is "X" and player 2 is "O" in the board.
 * TicTacToe toe = new TicTacToe(3);

	toe.move(0, 0, 1); -> Returns 0 (no one wins)
	|X| | |
	| | | |    // Player 1 makes a move at (0, 0).
	| | | |
	
	toe.move(0, 2, 2); -> Returns 0 (no one wins)
	|X| |O|
	| | | |    // Player 2 makes a move at (0, 2).
	| | | |
	
	toe.move(2, 2, 1); -> Returns 0 (no one wins)
	|X| |O|
	| | | |    // Player 1 makes a move at (2, 2).
	| | |X|
	
	toe.move(1, 1, 2); -> Returns 0 (no one wins)
	|X| |O|
	| |O| |    // Player 2 makes a move at (1, 1).
	| | |X|
	
	toe.move(2, 0, 1); -> Returns 0 (no one wins)
	|X| |O|
	| |O| |    // Player 1 makes a move at (2, 0).
	|X| |X|
	
	toe.move(1, 0, 2); -> Returns 0 (no one wins)
	|X| |O|
	|O|O| |    // Player 2 makes a move at (1, 0).
	|X| |X|
	
	toe.move(2, 1, 1); -> Returns 1 (player 1 wins)
	|X| |O|
	|O|O| |    // Player 1 makes a move at (2, 1).
	|X|X|X|

 * Follow up:
 * Could you do better than O(n2) per move() operation?
 * 
 * 
 * @author Sean
 *
 */
public class DesignTicTacToe {
	/**
     * Variables.
     */
    int[][] map;
    int winner;

    /** Initialize your data structure here. */
    public DesignTicTacToe(int n) {
        this.map = new int[n][n];
        this.winner = 0;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if(this.winner != 0) return this.winner;

        this.map[row][col] = player;

        return check(row, col, player) ? player : 0;
    }

    /**
     * This helper method check if there is a line 
     * horizontally, vertically or diagonally.
     */
    private boolean check(int row, int col, int player) {
        boolean bool = checkCol(row, player)
        			   || checkRow(col, player)
        			   || checkDig(player);
        if(bool) this.winner = player;
        return bool;
    }

    private boolean checkCol(int row, int player) {
        for(int i = 0; i < this.map[row].length; ++ i)
            if(this.map[row][i] != player) return false;
        return true;
    }

    private boolean checkRow(int col, int player) {
        for(int i = 0; i < this.map.length; ++ i)
            if(this.map[i][col] != player) return false;
        return true;
    }

    private boolean checkDig(int player) {
    		boolean straight = true;
    		boolean reverse = true;
        for(int i = 0; i < this.map.length; ++ i) {
            if(this.map[i][i] != player) straight = false;
            if(this.map[i][this.map.length - 1 - i] != player) reverse = false;
        }
        return straight || reverse;
    }
}
