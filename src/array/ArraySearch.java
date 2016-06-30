package array;


public class ArraySearch {
	static char[][] table;
	static String string;
	public static boolean exist(char[][] board, String word) {
        if(board==null||word.length()==0) return false;
        string = word;
        table = board;
        int c = board.length;
        int r = board[0].length;
        boolean[][] visited = new boolean[c][r];
        boolean bool = false;
        for(int i=0; i<c; ++i) {
        	for(int j=0; j<r; ++j) {
        		if(board[i][j]==word.charAt(0)) {
        	        bool = search(i,j,1,visited);
        	        if(bool) return bool;
        		}
        	}
        }
        return bool;
    }
	public static boolean search(int h, int v, int n, boolean[][] visited) {
		visited[h][v] = true;
		if(n==string.length()) return true;
		boolean bool = false;
		if(h>0&&!visited[h-1][v]&&table[h-1][v]==string.charAt(n)) {
			bool = search(h-1,v,n+1,visited);
			if(bool) { 
				visited[h][v] = false;
				return bool;
			}
		}
		if(h<table.length-1&&!visited[h+1][v]&&table[h+1][v]==string.charAt(n)) {
			bool = search(h+1,v,n+1,visited);
			if(bool) {
				visited[h][v] = false;
				return bool;
			}
		}
		if(v>0&&!visited[h][v-1]&&table[h][v-1]==string.charAt(n)) {
			bool = search(h,v-1,n+1,visited);
			if(bool) {
				visited[h][v] = false;
				return bool;
			}
		}
		if(v<table[0].length-1&&!visited[h][v+1]&&table[h][v+1]==string.charAt(n)) {
			bool = search(h,v+1,n+1,visited)||bool;
		}
		visited[h][v] = false;
		return bool;
	}
	public static void main(String[] args) {
		char[][] board = {{'a','b','c','e'},{'s','f','e','s'},{'a','d','e','e'}};
		String word = "abceseeefs";
		System.out.println(exist(board,word));
	}
}
