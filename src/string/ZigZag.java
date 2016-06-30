package string;

public class ZigZag {
	public static String convert(String s, int nRows) {
	        int length = s.length();
	        String newS = new String();
	        String[] subS = new String[nRows];
	        for(int n=0; n<nRows; ++n){
	        	subS[n] = new String();
	        }
	        int p = 0;
	        boolean flag = true;
	        for(int i=0; i<length; ++i){
	        	subS[p] += s.charAt(i);
	        	if(p==0) flag = true;
	        	if(p==nRows-1) flag = false;
	        	if(flag&&p+1<nRows) p++;
	        	else if(!flag&&p-1>-1) p--;
	        }
	        for(int n=0; n<nRows; ++n) newS += subS[n];
	        return newS;
	    }
	public static void main(String[] args){
		String s = "PAYPALISHIRING";
		System.out.println(convert(s,1));
	}
}
