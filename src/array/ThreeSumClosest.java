package array;

import java.util.Arrays;

public class ThreeSumClosest {
	public static int threeSumClosest(int[] num, int target) {
		Arrays.sort(num);
		if(num.length<=3){
			int sum = 0;
			for(int i=0; i<num.length; ++i) sum += num[i];
			return sum;
		}
        int sum = num[0]+num[1]+num[2];
        loop:
        for(int i=0; i<num.length-2; ++i){
        	//int t = target-num[i];
        	int start = i+1;
        	int end = num.length-1;
        	int preSum = num[start]+num[end]+num[i];
        	while(start<end){
        		int temp = num[start]+num[end]+num[i];
        		if(Math.abs(target-temp)>Math.abs(target-preSum)) break;
        		preSum = temp;
        		if(Math.abs(target-temp)<Math.abs(target-sum)) {
        			System.out.println(num[start]+" "+num[end]+" "+num[i]);
                    System.out.println(start+" "+end);
                    sum = temp;
        		}
        		if(temp<target){
        			start++;
        			continue;
        		}
        		if(temp>target){
        			end--;
        			continue;
        		}
        		break loop;
        	}
        }
        return sum;
    }
	public static void main(String[] args){
		int[] a = {1,2,33,23,2423,33,23,1,7,6,8787,5,33,2,3,-23,-54,-67,100,400,-407,-500,-35,-8,0,0,7,6,0,1,2,-56,-89,24,2};
		System.out.println(threeSumClosest2(a,148));
	}
	
	
	
	public static int threeSumClosest2(int[] numbers ,int target) {
        // write your code here
        if(numbers == null || numbers.length < 3) return -1;
        Arrays.sort(numbers);
        int result = Integer.MAX_VALUE/2;
        
        for(int i=2; i<numbers.length; ++i) {
            int begin = 0;
            int end = i-1;
            while(begin < end) {
                int sum = numbers[begin]+numbers[end]+numbers[i];
                if(sum == target) return sum;
                if(Math.abs(sum-target) < Math.abs(result-target)) {
                    System.out.println(numbers[begin]+" "+numbers[end]+" "+numbers[i]);
                    System.out.println(begin+" "+end);
                		result = sum;
                }
                if(sum > target) end--;
                else begin++;
            }
        }
        
        return result;
    }
}
