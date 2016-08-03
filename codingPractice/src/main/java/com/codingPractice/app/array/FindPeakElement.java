package com.codingPractice.app.array;

public class FindPeakElement {
	public static int findPeakElement(int[] num) {
        if(num.length==0) return -1;
        return findPos(0,num.length-1, num);
    }
	static int findPos(int begin, int end, int[] num) {
		if(begin>end) return begin;
		int mid = (begin+end)/2;
		if((mid==num.length-1||num[mid]>num[mid+1])&&(mid==0||num[mid]>num[mid-1])) return mid;
		if(mid!=num.length-1&&num[mid]>num[mid+1]) return findPos(begin,mid-1,num);
		else return findPos(mid+1,end,num);
	}
	public static int findPeakElement2(int[] num) {
		int n = num.length;
        if(n == 1) {
            return 0;
        }

        int start = 0;
        int end = n - 1;
        int mid = 0;

        while(start <= end) {
            mid = start + (end - start) / 2;
            if((mid == 0 || num[mid] >= num[mid - 1]) &&
               (mid == n - 1 || num[mid] >= num[mid + 1])) {
                    return mid;
            }else if(mid > 0 && num[mid-1] > num[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return mid;
	}
	public static void main(String[] args) {
		int[] num = {1};
		System.out.println(findPeakElement(num));
	}
}
