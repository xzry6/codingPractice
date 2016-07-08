package number;

public class ValidPerfectSquare {
	public static void main(String[] args) {
		System.out.println(isPerfectSquare(2147483647));
	}

	public static boolean isPerfectSquare(int num) {
        // Deal with edge cases first.
        if(num < 0) {
            return false;
        }
        if(num == 0) {
            return true;
        }
        // Find the range.
        long begin = 0;
        long end = 1;
        while(end * end < num) {
            begin = end;
            end *= 2;
        }
        if(end * end == num) {
            return true;
        }
        // Binary search.
        while(begin + 1 < end) {
            long mid = begin + (end - begin) / 2;
            if(mid * mid == num) {
                return true;
            }
            if(mid * mid > num) {
                end = mid;
            } else {
                begin = mid;
            }
        }
        return false;
    }
}
