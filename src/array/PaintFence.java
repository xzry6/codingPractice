package array;

/**
 * There is a fence with n posts, each post can be painted with one of the k colors.
 * You have to paint all the posts such that no more than two adjacent fence posts
 * have the same color.
 * 
 * Return the total number of ways you can paint the fence.
 * 
 * Note:
 * n and k are non-negative integers.
 * 
 * @author Sean
 *
 */
public class PaintFence {
	public int numWays(int n, int k) {
        if(n == 0) return 0;
        if(n == 1) return k;
        int[] arr = new int[n];
        arr[0] = k;
        arr[1] = k * k;
        for(int i = 2; i < n; ++ i)
        		arr[i] = arr[i - 2] * (k - 1)
        			   + arr[i - 1] * (k - 1);
        return arr[n - 1];
    }
}
