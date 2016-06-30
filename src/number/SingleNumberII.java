package number;

public class SingleNumberII {
	public static int singleNumber(int[] A) {
        int result = 0;
        for(int i=0; i<32; ++i) {
        	int count = 0;
        	for(int j=0; j<A.length; ++j) {
        		int temp = 0;
        		temp |= ((A[j]>>i)&1);
        		count += temp;
        	}
        	result |= (count%3)<<i;
        }
        return result;
    }
	public static void main(String[] args) {
		int[] A = {2,2,3,2};
		System.out.println(singleNumber(A));
	}
}
