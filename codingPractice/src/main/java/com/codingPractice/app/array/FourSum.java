package com.codingPractice.app.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		if (nums == null)
			return null;
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		for (int p1 = 0; p1 < nums.length; ++p1) {
			if (p1 != 0 && nums[p1] == nums[p1 - 1])
				continue;
			for (int p4 = nums.length - 1; p4 > p1 + 2; --p4) {
				if (p4 != nums.length - 1 && nums[p4] == nums[p4 + 1])
					continue;
				int p2 = p1 + 1;
				int p3 = p4 - 1;
				while (p2 < p3) {
					if (nums[p1] + nums[p2] + nums[p3] + nums[p4] == target) {
						List<Integer> temp = new ArrayList<Integer>();
						temp.add(nums[p1]);
						temp.add(nums[p2]);
						temp.add(nums[p3]);
						temp.add(nums[p4]);
						list.add(temp);
						while (p2 < p3 && nums[p2] == nums[++p2])
							;
						while (p2 < p3 && nums[p3] == nums[--p3])
							;
					} else if (nums[p1] + nums[p2] + nums[p3] + nums[p4] > target)
						p3--;
					else
						p2++;
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {
		int[] num = { 1,0,-1,-1,-1,-1,0,1,1,1,2 };
		ArrayList<ArrayList<Integer>> list = new FourSum().fourSum3(num, 2);
		for (int n = 0; n < list.size(); ++n) {
			for (int i = 0; i < list.get(n).size(); ++i) {
				System.out.print(list.get(n).get(i) + " ");
			}
			System.out.println();
		}
	}
	
	public ArrayList<ArrayList<Integer>> fourSum2(int[] numbers, int target) {   
        //write your code here
        if(numbers == null || numbers.length == 0) return null;
        Arrays.sort(numbers);
        HashMap<Integer, ArrayList<ArrayList<Integer>>> map = new HashMap<Integer, ArrayList<ArrayList<Integer>>>();
        for(int i=0; i<numbers.length-1; ++i) {
            for(int j=i+1; j<numbers.length; ++j) {
                int sum = numbers[i]+numbers[j];
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(i);
                temp.add(j);
                ArrayList<ArrayList<Integer>> newlist = new ArrayList<ArrayList<Integer>>();
                if(map.containsKey(sum))
                    newlist = map.get(sum);
                newlist.add(temp);
                map.put(sum, newlist);
            }
        }
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        Iterator<Integer> iter = map.keySet().iterator();
        while(iter.hasNext()) {
            int sum = iter.next();
            if(sum > 0 || !map.containsKey(target-sum)) continue;
            ArrayList<ArrayList<Integer>> curlist = map.get(sum);
            ArrayList<ArrayList<Integer>> newlist = map.get(target-sum);
            for(ArrayList<Integer> temp:curlist) {
                int cur0 = temp.get(0);
                int cur1 = temp.get(1);
                for(ArrayList<Integer> newtemp:newlist) {
                    int new0 = newtemp.get(0);
                    int new1 = newtemp.get(1);
                    if(!newtemp.contains(cur0) && !newtemp.contains(cur1)) {
                        ArrayList<Integer> the = new ArrayList<Integer>();
                        the.add(numbers[cur0]);
                        the.add(Math.min(numbers[cur1], numbers[new0]));
                        the.add(Math.max(numbers[cur1], numbers[new0]));
                        the.add(numbers[new1]);
                        list.add(the);
                    }
                }
            }
        }
        return list;
    }

	public ArrayList<ArrayList<Integer>> fourSum3(int[] numbers, int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        // Deal with null and empty class first.
        if(numbers == null || numbers.length == 0) return list;
        // Have a hash table saving key.
        Arrays.sort(numbers);
        Map<Integer, ArrayList<ArrayList<Integer>>> map = new HashMap<Integer, ArrayList<ArrayList<Integer>>>();
        for(int i=0; i<numbers.length-1; ++i) {
//            if(i != 0 && numbers[i-1] == numbers[i]) continue;
            for(int j=i+1; j<numbers.length; ++j) {
//                if(j != i+1 && numbers[j-1] == numbers[j]) continue;
                int sum = numbers[i] + numbers[j];
                ArrayList<ArrayList<Integer>> sumList = new ArrayList<ArrayList<Integer>>();
                if(map.containsKey(sum))
                    sumList = map.get(sum);
                else map.put(sum, sumList);
                ArrayList<Integer> temp = new ArrayList<Integer>();
                if(numbers[i] < numbers[j]) {
                		temp.add(i);
                		temp.add(j);
                } else {
                		temp.add(j);
                		temp.add(i);
                }
                sumList.add(temp);
            }
        }

        Iterator<Integer> iterator = map.keySet().iterator();
        while(iterator.hasNext()) {
            int sum = iterator.next();
            if(!map.containsKey(target - sum)) continue;
            if(target - sum == sum && map.get(sum).size() == 1) continue;
            ArrayList<ArrayList<Integer>> sumList1 = map.get(sum);
            ArrayList<ArrayList<Integer>> sumList2 = map.get(target - sum);
            for(ArrayList<Integer> sum1:sumList1) {
                for(ArrayList<Integer> sum2:sumList2) {
                    if(sum1 == sum2) continue;
                    if(sum1.contains(sum2.get(0)) || sum1.contains(sum2.get(1))) continue;
                    int[] arr = new int[4];
                    arr[0] = numbers[sum1.get(0)];
                    arr[1] = numbers[sum1.get(1)];
                    arr[2] = numbers[sum2.get(0)];
                    arr[3] = numbers[sum2.get(1)];
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    Arrays.sort(arr);
                    for(int arrNum:arr) temp.add(arrNum);
                    boolean bool = true;
                    for(ArrayList<Integer> tempList:list) {
                        int count = 0;
                    		for(int z=0; z<tempList.size(); ++z) {
                    			if(temp.get(z) == tempList.get(z)) count++;
                    		}
                    		if(count == 4) {
                    			bool = false;
                    			break;
                    		}
                    }
                    if(bool) 
                    		list.add(temp);
                }
            }
        }
        // Return list.
        return list;
    }
}
