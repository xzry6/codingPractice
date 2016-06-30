package array;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SudokuSolver {
	
	private boolean solved = false;
	
	public void solveSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length != 9)
        		return;
    }
	
	private void backtrack(char[][] board, int x, int y) {
		if(solved) return;
		if(x > 8) {
			if(y == 8) {
				solved = true;
				return;
			}
			x = 0;
			y ++;
		}
		Set<Integer> set = check(board, x, y);
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			int num = it.next();
			board[x][y] = (char)(num+48);
			backtrack(board, x+1, y);
			board[x][y] = '.';
		}
	}
	
	private Set<Integer> check(char[][] board, int x, int y) {
		Set<Integer> set = initialSet();
		//check row& column
		for(int i=0; i<9; ++i) {
			if(board[x][i] != '.') {
				int num = board[x][i]-48;
				set.remove(num);
			}
			if(board[i][y] != '.') {
				int num = board[i][y]-48;
				set.remove(num);
			}
		}
		//check area
		int a = x/3;
		int b = y/3;
		for(int i=0; i<3; ++i) {
			for(int j=0; j<3; ++j) {
				if(board[3*a+i][3*b+j] != '.') {
					int num = board[3*a+i][3*b+j]-48;
					set.remove(num);
				}
			}
		}
		return set;
	}
	
	private Set<Integer> initialSet() {
		Set<Integer> set = new HashSet<Integer>();
		for(int i=1; i<10; ++i)
			set.add(i);
		return set;
	}
}
