package string;

public class IntegerToRoman {
	public static String intToRoman(int num) {
		char[] c = {'I','V','X','L','C','D','M'};
		String s = new String();
		if(num>3999||num<0) return null;
		int count = 0;
		while(num!=0){
			int temp = num%10;
			num -= temp;
			switch(temp){
			case 0: count += 2;
					num /= 10;
					break;
			case 9: s = c[count+2]+s;
					temp -= 10;
					break;
			case 5: s = c[count+1]+s;
					temp -= 5;
					break;
			case 4: s = c[count+1]+s;
					temp -= 5;
					break;
			default: s = c[count]+s;
					 temp -= 1;
					 break;
			}
			num += Math.abs(temp);
		}
		return s;
    }
	public static void main(String[] args){
		System.out.println(intToRoman(888));
	}
}
