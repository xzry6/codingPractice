package bitManipulation;

public class ReverseBits {
	public static void main(String[] args) {
		int a = 1;
		int b = 0;
		for(int i=0; i<32; ++i) {
			b<<=1;
			int temp = a&1;
			b|=temp;
			a>>>=1;
		}
		System.out.println(b);
	}
}
