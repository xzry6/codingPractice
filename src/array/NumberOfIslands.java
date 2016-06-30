package array;

public class NumberOfIslands {
	public static int numIslands(char[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0) return 0;
        boolean[][] bool = new boolean[grid.length][grid[0].length];
        int count = 0;
        while(true) {
        	int x = -1;
        	int y = -1;
        	Loop:
        	for(int i=0; i<grid.length; ++i) {
        		for(int j=0; j<grid[0].length; ++j) {
        			if(!bool[i][j]&&grid[i][j]=='1') {
        				x = i;
        				y = j;
        				break Loop;
        			}
        		}
        	}
        	if(x==-1) break;
        	recursive(grid,x,y,bool);
        	count++;
        }
        return count;
    }
	static void recursive(char[][] grid, int x, int y, boolean[][] bool) {
		if(x<0||x>=grid.length||y<0||y>=grid[0].length||bool[x][y]) return;
		char c = grid[x][y];
		bool[x][y] = true;
		if(c=='0') return;
		recursive(grid,x+1,y,bool);
		recursive(grid,x-1,y,bool);
		recursive(grid,x,y+1,bool);
		recursive(grid,x,y-1,bool);
	}
	public static int numIslands2(char[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0) return 0;
        int count = 0;
        for(int i=0; i<grid.length; ++i) {
        	for(int j=0; j<grid[0].length; ++j) {
        		if(grid[i][j]=='1') {
        			recursive2(grid,i,j);
        			count++;
        		}
        	}
        }
        return count;
    }
	static void recursive2(char[][] grid, int x, int y) {
		if(x<0||x>=grid.length||y<0||y>=grid[0].length||grid[x][y]=='0'||grid[x][y]=='9') return;
		grid[x][y] = '9';
		recursive2(grid,x+1,y);
		recursive2(grid,x-1,y);
		recursive2(grid,x,y+1);
		recursive2(grid,x,y-1);
	}
	public static void main(String[] args) {
		char[][] c = {{'1','1','0','0','0'},
						{'1','1','0','0','0'},
						{'0','0','1','0','0'},
						{'0','0','0','1','1'}
					};
		System.out.println(numIslands(c));

		System.out.println(numIslands2(c));
		
		
		
	}
}
