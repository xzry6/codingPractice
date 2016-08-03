package com.codingPractice.app.dataStructure;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s) {
        if(s == null) return null;
        List<String> list = new ArrayList<String>();
        if(s.length() < 4 || s.length() > 12) 
        		return list;
        recursive(list, new StringBuffer(), s, 0, 0);
        return list;
    }
	
	private void recursive(List<String> list,
							 StringBuffer sb,
							 String s,
							 int pos,
							 int words) {
		if(words == 4) {
			if(pos == s.length())
				list.add(sb.deleteCharAt(sb.length()-1).toString());
			return;
		}
		for(int p=1; p<=3; ++p) {
			if(pos+p > s.length()) break;
			String temp = s.substring(pos, pos+p);
			if(judge(temp))
				recursive(list, sb.append(temp).append('.'), s, pos+p, words+1);
			sb.delete(pos+words, sb.length());
		}
	}
	
	private boolean judge(String s) {
		int i = Integer.parseInt(s);
		if(i>255 || (i < 10 && s.length() > 1) 
				 || (i < 100 && s.length() > 2)) return false;
		return true;
	}
	
	public static void main(String[] args) {
		RestoreIPAddresses sa = new RestoreIPAddresses();
		List<String> list = sa.restoreIpAddresses("000255");
		for(String s:list)
			System.out.println(s);
	}
}
