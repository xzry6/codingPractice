package bitManipulation;

/**
 * Given a non negative integer number num. 
 * For every numbers i in the range 0 ≤ i ≤ num,
 *  calculate the number of 1's in their binary 
 *  representation and return them as an array.
 * 
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2].
 * 
 * Follow up:
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)). 
 * But can you do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? 
 * 
 * @author Sean
 *
 */
public class CountingBits {
	/*
     * f(0) = 0;
     * f(1) = f(0) + 1;
     * f(2) = f(1) + 0;
     * f(3) = f(1) + 1;
     *  .      .     .
     *  .      .     .
     * f(7) = f(3) + 1;
     *  .      .     .
     *  .      .     .
     *  .      .     .
     * f(n) = f(n/2) + n%2;
     */
    public int[] countBits(int num) {
        if(num < 0) return null;

        int[] arr = new int[num + 1];

        for(int i = 1; i <= num; ++ i) 
            arr[i] = arr[i/2] + i%2;

        return arr;
    }
}
