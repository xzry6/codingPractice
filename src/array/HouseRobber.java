package array;

public class HouseRobber {
	public int rob(int[] num) {
        int a = 0;
        int b = 0;
        for(int i=0; i<num.length; ++i) {
        	if(i%2==0){
        		a+=num[i];
        		if(a<b) a=b;
        	}
        	else {
        		b+=num[i];
        		if(b<a) b=a;
        	}
        }
        return Math.max(a, b);
    }
}
