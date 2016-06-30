package string;

import java.util.ArrayList;
import java.util.List;

public class StrStr {
    public int strStr(String source, String target) {
        //write your code here
    		if(target==null || source==null) return -1;
    		if(target.length()==0) return 0;
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<source.length(); ++i) {
            char tempChar = source.charAt(i);
            if(!list.isEmpty() && i-list.get(0)==target.length())
                return list.get(0);
            for(int l=0; l<list.size(); ++l) {
                if(target.charAt(i-list.get(l))!=tempChar)
                    list.remove(l--);
            }
            if(tempChar==target.charAt(0))
                list.add(i);
        }
        return -1;
    }
    
    public int strStr3(String source, String target) {
    		int[] arr = new int[target.length()];
    		for(int i=1; i<arr.length; ++i) {
    			int pos = arr[i-1];
    			while(target.charAt(i) != target.charAt(pos)) {
    				if(pos == 0) break;
    				pos = arr[pos-1];
    			}	
    			if(target.charAt(i) == target.charAt(pos)) arr[i]++;
    		}
    		int i = 0, j = 0;
    		while(i<target.length() && j<source.length()) {
    			if(target.charAt(i) == source.charAt(j)) i++;
    			else i = i != 0 ? i = arr[i-1]:0;
    			j++;
    		}
    		
    		return i == target.length() ? j-target.length():-1;
    }
    
    public int strStr2(String haystack, String needle) {
    	
    		if(haystack==null || needle==null) return -1;
    		if(needle.length()==0) return 0;
    		
    		for(int i=0; i<haystack.length()-needle.length()+1; ++i) {
    			for(int j=0; j<needle.length(); ++j) {
    				if(haystack.charAt(i+j)!=needle.charAt(j)) break;
    				if(j == needle.length()-1) return i;
    			}
    		}
    		return -1;
    }
    
    public int strStr4(String haystack, String needle) {
        if(needle == null) return -1;
        if(needle.length() == 0) return 0;
        if(haystack == null || haystack.length() == 0) return -1;

        for(int i=0; i<haystack.length(); ++i) {
            int py = 0;
            while(i+py < haystack.length() &&
                  py < needle.length() &&
                  haystack.charAt(i+py) == needle.charAt(py)) {
                py ++;
            }
            if(py == needle.length()) return i;
        }

        return -1;
    } 
  
    public static void main(String[] args) {
    		StrStr str = new StrStr();
    		System.out.println(str.strStr4("abbababa", "ababa"));
    }

}
