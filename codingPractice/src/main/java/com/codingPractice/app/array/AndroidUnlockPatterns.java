package com.codingPractice.app.array;

/**
 * Given an Android 3x3 key lock screen and two integers m and n,
 * where 1 ≤ m ≤ n ≤ 9, count the total number of unlock patterns
 * of the Android lock screen, which consist of minimum of m keys
 * and maximum n keys.
 * 
 * Rules for a valid pattern:
 * Each pattern must connect at least m keys and at most n keys.
 * All the keys must be distinct.
 * If the line connecting two consecutive keys in the pattern passes
 * through any other keys, the other keys must have previously selected
 * in the pattern. No jumps through non selected key is allowed.
 * 
 * The order of keys used matters.
 * 
 * Explanation:
	| 1 | 2 | 3 |
	| 4 | 5 | 6 |
	| 7 | 8 | 9 |
*
* Invalid move: 4 - 1 - 3 - 6 
* Line 1 - 3 passes through key 2 which had not been selected in the pattern.
* 
* Invalid move: 4 - 1 - 9 - 2
* Line 1 - 9 passes through key 5 which had not been selected in the pattern.
* 
* Valid move: 2 - 4 - 1 - 3 - 6
* Line 1 - 3 is valid because it passes through key 2, which had been selected in the pattern
* 
* Valid move: 6 - 5 - 4 - 1 - 9 - 2
* Line 1 - 9 is valid because it passes through key 5, which had been selected in the pattern.
* 
* Example:
* Given m = 1, n = 1, return 9.
 * 
 * @author Sean
 *
 */
public class AndroidUnlockPatterns {
	public static void main(String[] args) {
		AndroidUnlockPatterns aup = new AndroidUnlockPatterns();
		System.out.println(aup.numberOfPatterns(2, 2));
	}

	public int numberOfPatterns(int m, int n) {
        int skip[][] = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5;

        int sum = recursive(new boolean[10], skip, 5, 1, m, n);
        sum += recursive(new boolean[10], skip, 1, 1, m, n) * 4;
        sum += recursive(new boolean[10], skip, 2, 1, m, n) * 4;

        return sum;
    }

    public int recursive(boolean[] visited, int[][] skip, int cur, int count, int min, int max) {
        if(visited[cur]) return 0;

        visited[cur] = true;
        int sum = count >= min ? 1 : 0;
        if(count == max) {
        		visited[cur] = false;
        		return sum;
        }

        for(int i = 1; i < 10; ++ i) {
            if(visited[i]) continue;
            if(skip[cur][i] != 0 && !visited[skip[cur][i]]) continue;
            sum += recursive(visited, skip, i, count + 1, min, max);
        }

        visited[cur] = false;
        return sum;
    }
}
