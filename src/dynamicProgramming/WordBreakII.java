package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class WordBreakII {
	boolean[] bool;
	String ss;
	Set<String> dictionary;
	List<String> list;
	public List<String> wordBreak(String s, Set<String> dict) {
        list = new ArrayList<String>();
		if(s.length()==0||dict.size()==0) return list;
        dictionary = dict;
        ss = s;
        bool = new boolean[ss.length()+1];
        Arrays.fill(bool,true);
        recursive(0,"");
        return list;
    }
	private void recursive(int begin, String s) {
		if(begin<ss.length()) {
			for(int i=begin; i<ss.length(); ++i) {
				String sss = ss.substring(begin, i+1);
				if(dictionary.contains(sss)&&bool[i+1]) {
					if(s.length()!=0) sss = s+" "+sss;
					int len = list.size();
					recursive(i+1,sss);
					if(len==list.size()) bool[i+1]=false;
				}
			}
		} else {
			list.add(s);
			return;
		}
	}
}
