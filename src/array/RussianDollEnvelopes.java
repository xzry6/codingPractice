package array;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {

	int[][] map;

    public int maxEnvelopes(int[][] envelopes) {
        // Deal with empty and null first.
        if(envelopes == null || envelopes.length == 0 || envelopes[0].length == 0)
            return 0;

        int maxWidth = 0;
        int maxHeight = 0;
        for(int[] envelope:envelopes) {
            maxWidth = Math.max(maxWidth, envelope[0]);
            maxHeight = Math.max(maxHeight, envelope[1]);
        }

        map = new int[maxWidth + 1][maxHeight + 1];

        // Sort.
        Arrays.sort(envelopes, comparator);
        // Recursive.
        
        return recursive(envelopes, 0, 0, 0);
    }

    private int recursive(int[][] envelopes, int index, int width, int height) {
        if(index >= envelopes.length) return 0;
        int[][] map = this.map;
        if(map[width][height] != 0) return map[width][height];

        for(int i = index; i < envelopes.length; ++ i) {
            int curWidth = envelopes[i][0];
            int curHeight = envelopes[i][1];

            if(curWidth <= width || curHeight <= height) continue;

            int pre = recursive(envelopes, i + 1, curWidth, curHeight) + 1;
            map[width][height] = Math.max(map[width][height], pre);
        }

        return map[width][height];
    }

    /**
     * Array Comparator.
     */
    private Comparator<int[]> comparator = new Comparator<int[]>() {
        @Override
        public int compare(int[] a1, int[] a2) {
            return a1[0] == a2[0] ? a1[1] - a2[1] : a1[0] - a2[0];
        }
    };
}
