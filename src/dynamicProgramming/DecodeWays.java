package dynamicProgramming;

public class DecodeWays {
	public static int numDecodings(String s) {
        if(s.length()==0||s.charAt(0)=='0') return 0;
        /*while(s.charAt(0)=='0'){
        	s = s.substring(1);
        	if(s.length()==0) return 0;
        }*/
        int[] way = new int[s.length()+1];
        way[0] = 1;
        way[1] = 1;
        for(int i=1; i<s.length(); ++i){
        	way[i+1] = way[i];
        	if(s.charAt(i-1)=='1'&&s.charAt(i)!='0'||(s.charAt(i-1)=='2'&&s.charAt(i)<='6'&&s.charAt(i-1)!='0'))
        		way[i+1] += way[i-1];
        	if(s.charAt(i)=='0'){
        		if(s.charAt(i-1)!='1'&&s.charAt(i-1)!='2') return 0;
        		else way[i+1] = way[i-1];
        	}
        }
        return way[s.length()];
    }
	public static void main(String[] args){
		String s = "120";
		System.out.println(numDecodings(s));
	}
}
