package array;

public class BombEnemy {
	public static void main(String[] args) {
		char[][] grid = {{'0', 'W', 'E', 'W'}};
		System.out.println(maxKilledEnemies(grid));
	}

	public static int maxKilledEnemies(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int height = grid.length;
        int width = grid[0].length;
        int[][] sums = new int[height][width];
        for(int h = 0; h < height; ++ h) {
            sums[h][0] = grid[h][0] == 'E' ? 1 : 0;
            for(int w = 1; w < width; ++ w)
                sums[h][w] = grid[h][w] == 'W' ? 0 : (grid[h][w] == 'E' ? sums[h][w - 1] + 1 : sums[h][w - 1]);
            for(int w = width - 2; w >= 0; -- w)
                sums[h][w] = grid[h][w] == 'W' ? 0 : Math.max(sums[h][w + 1], sums[h][w]);
        }

        int max = 0;
        for(int w = 0; w < width; ++ w) {
            int count = 0;
            for(int h = 0; h < height; ++ h) {
                sums[h][w] += grid[h][w] == 'W' ? 0 : count;
                count = grid[h][w] == 'W' ? 0 : (grid[h][w] == 'E' ? count + 1 : count);
            }
            count = 0;
            for(int h = height - 1; h >= 0; -- h) {
                sums[h][w] += grid[h][w] == 'W' ? 0 : count;
                if(grid[h][w] == '0') max = Math.max(max, sums[h][w]);
                count = grid[h][w] == 'W' ? 0 : (grid[h][w] == 'E' ? count + 1 : count);
            }
        }

        return max;
    }
}
