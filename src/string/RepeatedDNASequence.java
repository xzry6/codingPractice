package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RepeatedDNASequence {
	public static List<String> findRepeatedDnaSequences(String s) {
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		List<String> list = new ArrayList<String>();
		int t = 0, i = 0, ss = s.length();
	    while (i < 9)
	        t = t << 3 | (s.charAt(i++) & 7);
	    while (i < ss)
	    	t = t << 3 & 0x3FFFFFFF | (s.charAt(i++) & 7);
	    if(hash.containsKey(t)) {
	    	int temp = hash.get(t);
	    	if (temp == 1) {
	    		list.add(s.substring(i - 10, i));
	    	}
        	hash.put(t, temp++);
	    } else hash.put(t,1);
	    
	            
	    return list;
    }
	public static void main(String[] args) {
		//List<String> list = findRepeatedDnaSequences("AAAAAGGGGGAAAAAGGGGGGAA");
	}
}
