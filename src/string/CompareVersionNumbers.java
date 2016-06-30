package string;

public class CompareVersionNumbers {
	static String str;
	public static int compareVersion(String version1, String version2) {
		while(version1.length()!=0||version2.length()!=0) {
			int val1 = StoI(version1);
			version1 = str;
			int val2 = StoI(version2);
			version2 = str;
			int com = compare(val1,val2);
			if(com==0) continue;
			else return com;
		}
		if(version1.length()==0&&version2.length()==0) return 0;
		if(version1.length()==0) return -1;
		return 1;
    }
	public static int compare(int a, int b) {
		if(a>b) return 1;
		if(a<b) return -1;
		return 0;
	}
	public static int StoI(String s) {
		int length = s.length();
		if(length==0) return 0;
		int position = 0;
		while(position<length&&s.charAt(position)!='.') position++;
		String subs = s.substring(0, position);
		if(position==length) str = s.substring(position);
		else str = s.substring(position+1);
		int val = Integer.parseInt(subs);
		return val;
	}
	public static void main(String[] args) {
		String s1 = "1.0";
		String s2 = "1.1";
		//////////////////////////////////////
		String[] a = s1.split("\\.");
		//////////////////////////////////////
		System.out.println(a[0]);
		System.out.println(a[1]);
		System.out.println(compareVersion(s1,s2));
	}
}
