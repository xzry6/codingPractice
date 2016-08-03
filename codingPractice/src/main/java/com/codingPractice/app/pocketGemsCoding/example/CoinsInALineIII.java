package com.codingPractice.app.pocketGemsCoding.example;

public class CoinsInALineIII {
	// Global hash map to avoid duplicate calculation.
    int[][] map;
    boolean[][] flag;

    public boolean firstWillWin(int[] values) {
        // Deal with null and empty value first.
        if(values == null || values.length == 0)
            return false;
        // Initialize map;
        map = new int[values.length][values.length];
        flag = new boolean[values.length][values.length];
        // Calculate the sum of all values.
        int sum = 0;
        for(int value:values)
            sum += value;
        // Divide and conquer and return.
        int value = divideConquer(values, 0, values.length-1);
        for(int i=0; i<map.length; ++i) {
	    		for(int j=0; j<map.length; ++j) {
	    			System.out.print(map[i][j] + " ");
	    		}
	    		System.out.println();
	    		
	    }
        System.out.println(value);
        System.out.println(sum);
        return value > (sum - value);
    }

    private int divideConquer(int[] values, int begin, int end) {
        if(begin > end || begin >= values.length || end < 0) 
            return 0;
        // Return value if already traversed.
        if(flag[begin][end]) {
            return map[begin][end];
        }
        flag[begin][end] =  true;
        // If 1 number left.
        if(begin == end) {
            map[begin][end] = values[begin];
            return values[begin];
        }
        // If 2 number left.
        if(begin+1 == end) {
            int max = Math.max(values[begin], values[end]);
            map[begin][end] = max;
            return max;
        }
            
        // Divide and Conquer.
        int minLeft = Math.min(divideConquer(values, begin+1, end-1), 
        			      divideConquer(values, begin+2, end))
        			    + values[begin];
        int minRight = Math.min(divideConquer(values, begin+1, end-1),
        				   divideConquer(values, begin, end-2))
        				 + values[end];
        int value = Math.max(minLeft, minRight);
        map[begin][end] = value;
        // Return.
        return value;
    }

    public static void main(String[] args) {
    		CoinsInALineIII cial3 = new CoinsInALineIII();
    		int[] arr = {4,1,2,16,12,17,11};
    		System.out.print(cial3.firstWillWin(arr));
    		System.out.print(cial3.firstWillWin2(arr));
    }
    

    public boolean firstWillWin2(int[] values) {
        // Deal with emtpy and null first.
        if(values == null || values.length == 0) {
            return false;
        }
        // Have a map.
        int[][] map = new int[values.length][values.length];
        // Initialize the map.
        for(int i=0; i<values.length; ++i) {
            map[i][i] = values[i];
            if(i+1 != values.length) {
                map[i][i+1] = Math.max(values[i], values[i+1]);
            }
        }
        // Have a loop on the map.
        for(int i=2; i<values.length; ++i) {
            for(int j=0; j<values.length-i; ++j) {
                map[j][i+j] = Math.max(
                    Math.min(map[j][i+j-2], map[j+1][i+j-1]) + values[i+j],
                    Math.min(map[j+2][i+j], map[j+1][i+j-1]) + values[j]
                );
            }
        }
        
        // Calculate sum.
        int sum = 0;
        for(int value:values) {
            sum += value;
        }
        // Return.
        int score = map[0][map[0].length-1];
        System.out.println(score);
        System.out.println(sum);
        
        for(int i=0; i<values.length; ++i) {
        		for(int j=0; j<values.length; ++j) {
        			System.out.print(map[i][j] + " ");
        		}
        		System.out.println();
        }
        return score > sum - score;
    }
}
