package number;

public class UglyNumber {
	public boolean isUgly(int num) {
		if(num<=0) return false;
        for(int i=2; i<6; ++i) {
        	while(num%i==0)
        		num = num/i;
        }
        return num==1;
    }
}
