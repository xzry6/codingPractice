package com.codingPractice.app.array;

import java.util.Arrays;

/**
 * According to the Wikipedia's article:
 * "The Game of Life, also known simply as Life, 
 * is a cellular automaton devised by the British 
 * mathematician John Horton Conway in 1970."
 * 
 * Given a board with m by n cells,
 * each cell has an initial state live (1) or dead (0).
 * Each cell interacts with its eight neighbors (horizontal, vertical, diagonal)
 * using the following four rules (taken from the above Wikipedia article):
 * 
 * - Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * - Any live cell with two or three live neighbors lives on to the next generation.
 * - Any live cell with more than three live neighbors dies, as if by over-population.
 * - Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * 
 * Write a function to compute the next state (after one update) of the board given its current state.
 * 
 * Follow up: 
 * 
 * - Could you solve it in-place? 
 * Remember that the board needs to be updated at the same time: 
 * You cannot update some cells first and then use their updated values to update other cells.
 * 
 * - In this question, we represent the board using a 2D array.
 * In principle, the board is infinite,
 * which would cause problems when the active area encroaches the border of the array.
 * How would you address these problems?
 * 
 * 
 * @author Sean
 *
 */
public class GameOfLife {
	public static void main(String[] args) {
		GameOfLife gol = new GameOfLife();
		int[][] board = {
				{0, 0, 0, 0},
				{0, 1, 1, 0},
				{0, 1, 1, 0},
				{0, 0, 0, 0}
		};
		gol.gameOfLife(board);
		System.out.println(Arrays.deepToString(board));
	}

	public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;

        for(int i = 0; i < board.length; ++ i) {
            for(int j = 0; j < board[i].length; ++ j) {
                int lives = numberOfLives(i, j, board);
                if(lives == 3 && board[i][j] == 0) board[i][j] = 3;
                if((lives < 2 || lives > 3) && board[i][j] == 1) board[i][j] = 2;
            }
        }

        for(int i = 0; i < board.length; ++ i) {
            for(int j = 0; j < board[i].length; ++ j) {
                board[i][j] %= 2;
            }
        }
    }

    private int numberOfLives(int x, int y, int[][] board) {
        int lives = 0;
        for(int i = Math.max(x - 1, 0); i <= Math.min(x + 1, board.length - 1); ++ i) {
            for(int j = Math.max(y - 1, 0); j <= Math.min(y + 1, board[i].length - 1); ++ j) {
                if(i == x && j == y) continue;
                if(board[i][j] == 1 || board[i][j] == 2) lives ++;
            }
        }
        return lives;
    }
}
