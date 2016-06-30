package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SubsetsII {
	public static List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        HashMap<Integer,List<List<Integer>>> map = new HashMap<Integer,List<List<Integer>>>();
        List<Integer> temp = new ArrayList<Integer>();
        list.add(temp);
        for(int i=0; i<num.length; ++i) {
        	List<List<Integer>> compare = new ArrayList<List<Integer>>();
        	if(map.containsKey(num[i]))
        		compare = map.get(num[i]);
        	else {
        		map.put(num[i], compare);
        	}
        	int len = list.size();
        	for(int j=0; j<len; ++j) {
        		temp = new ArrayList<Integer>(list.get(j));
        		temp.add(num[i]);
        		boolean bool = false;
        		for(int k=0; k<compare.size(); ++k) {
        			if(temp.equals(compare.get(k))) {
        				bool = true;
        				break;
        			}
        		}
        		if(!bool) {
        			list.add(temp);
					compare.add(temp);
        		}
        	}
        }
        return list;
    }
	public static List<List<Integer>> subsetsWithDup2(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        list.add(temp);
        int size = temp.size();
        for(int i=0; i<num.length; ++i) {
        	int begin = 0;
        	if(i>0&&num[i]==num[i-1]) begin = size;
        	size = list.size();
        	for(int j=begin; j<size; ++j) {
        		temp = new ArrayList<Integer>(list.get(j));
        		temp.add(num[i]);
        		list.add(temp);
        	}
        }
        return list;
    }
	public static void main(String[] args) {
		int[] S = {1,2,1};
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list = subsetsWithDup(S);
		for(int i=0; i<list.size(); ++i) {
			List<Integer> temp = list.get(i);
			for(int j=0; j<temp.size(); ++j) {
				System.out.print(temp.get(j)+" ");
			}
			System.out.println();
		}
		
		
	}
	
	public List<List<Integer>> subsetsWithDup3(int[] nums) {
        if(nums==null) return null;
		Arrays.sort(nums);
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		recursive(list, new ArrayList<Integer>(), nums, -1);
		return list;
    }
    
    public void recursive(List<List<Integer>> list, 
			                List<Integer> tempList,
			                int[] num,
			                int pos) {
		if(pos == num.length) return;
		List<Integer> newList = new ArrayList<Integer>(tempList);
		if(pos != -1) newList.add(num[pos]);
		list.add(new ArrayList<Integer>(newList));
		for(int i=pos+1; i<num.length; ++i) {
			if(i != pos+1 && num[i] == num[i-1]) 
				continue;
			recursive(list, newList, num, i);
		}
	}
} 
