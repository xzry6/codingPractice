package array;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {

	public static void main(String[] args) {
		RussianDollEnvelopes rde = new RussianDollEnvelopes();
		int[][] arr = {{1, 1}, {1, 2}, {6, 15}, {2, 18}};
		System.out.println(rde.maxEnvelopesNlogN(arr));
	}

	public int maxEnvelopesNlogN(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0 || envelopes[0].length == 0) return 0;

        Arrays.sort(envelopes, comparatorNlogN);

        int[] dp = new int[envelopes.length];
        int max = 0;

        for(int[] envelope:envelopes) {
            int index = Arrays.binarySearch(dp, 0, max, envelope[1]);
            index = index >= 0 ? index : - (index + 1);
            dp[index] = envelope[1];
            if(index == max) max ++;
        }

        return max;
    }

    private Comparator<int[]> comparatorNlogN = new Comparator<int[]>() {
        @Override
        public int compare(int[] a1, int[] a2) {
            return a1[0] == a2[0] ? a2[1] - a1[1] : a1[0] - a2[0];
        }
    };

	public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0 || envelopes[0].length == 0) return 0;

        Arrays.sort(envelopes, comparator);

        int[] sum = new int[envelopes.length];
        int max = 1;
        Arrays.fill(sum, 1);

        for(int i = 0; i < envelopes.length; ++ i) {
            for(int j = 0; j < i; ++ j) {
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    sum[i] = Math.max(sum[i], sum[j] + 1);
                    max = Math.max(max, sum[i]);
                }
            }
        }

        return max;
    }

    private Comparator<int[]> comparator = new Comparator<int[]>() {
        @Override
        public int compare(int[] a1, int[] a2) {
            return a1[0] == a2[0] ? a1[1] - a2[1] : a1[0] - a2[0];
        }
    };
}
