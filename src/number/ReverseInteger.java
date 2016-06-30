package number;

public class ReverseInteger {
	public static int reverse(int x) {
        String s = Integer.toString(x);
        String news = new String();
        for(int i=s.length()-1; i>-1; --i){
        	char c = s.charAt(i);
        	if(i==0&&c=='0'||c=='-'||c=='+') news = c+news;
        	else news += c;
        }
        try{
        	int newx = Integer.parseInt(news);
            return newx;
        } catch(NumberFormatException e){
        	return -1;
        }
        
    }
	public static void main(String[] args){
		int x = 1534236469;
		System.out.println(reverse(x));
	}
}
