package array;

public class PlusOne {
	public int[] plusOne(int[] digits) {
		int l = digits.length-1;
		digits[l] += 1;
		boolean bool = false;
		if(digits[l]==10) {
			bool = true;
			digits[l] = 0;
		}
		for(int i=l-1; i>=0; --i) {
			if(bool) digits[i]++;
			if(digits[i]==10) {
				bool = true;
				digits[i] = 0;
			} else bool = false;
		}
		if(bool) {
			int[] ndigits = new int[l+2];
			System.arraycopy(digits, 0, ndigits, 1, l+1);
			ndigits[0] = 1;
			return ndigits;
		}
		return digits;
    }
}
