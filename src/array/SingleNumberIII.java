package array;

public class SingleNumberIII {
	public int[] singleNumber(int[] nums) {
        int[] rs = new int[2];
		int bit = 0;
        for(int i:nums)
        	bit ^= i;
        bit &= -bit;
        for(int i:nums) {
        	if((bit&i)==0)
        		rs[0] ^= i;
        	else rs[1] ^= i;
        }
        return rs;
    }
}
