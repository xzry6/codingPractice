package array;

public class LongestConsecutive {
	public int longestConsecutive(int[] num) {
        // write you code here
		if(num == null || num.length == 0) return -1;
        quickSort(num, 0, num.length-1);
        int pre = num[0];
        int max = 1;
        int count = 1;
        for(int i=1; i<num.length; ++i) {
            int n = num[i];
            if(n == pre+1)
            	max = Math.max(++count, max);
            else if(n != pre) count = 1;
            pre = n;
        }
        return max;
    }
	
	public void mergeSort(int[] num, int[] target, int start, int end) {
        if(start >= end) return;
        int mid = (end-start)/2+start;
        mergeSort(num, target, start, mid);
        mergeSort(num, target, mid+1, end);
        int p1 = start;
        int p2 = mid+1;
        int p = start;
        while(p1 <= mid && p2 <= end)
            target[p++] = num[p1] < num[p2] ? num[p1++]:num[p2++];
        while(p1 <= mid) 
            target[p++] = num[p1++];
        while(p2 <= end)
            target[p++] = num[p2++];
        for(int i=start; i<=end; ++i) 
            num[i] = target[i];
    }
	
	public void quickSort(int[] num, int start, int end) {
        if(start >= end) return;
        int p1 = start;
        int p2 = end;
        int pivot = num[p2];
        while(p1 < p2) {
            while(num[p1] <= num[end] && p1 < p2)
                p1++;
            num[p2] = num[p1];
            while(num[p2] >= num[end] && p1 < p2)
                p2--;
            num[p1] = num[p2];
        }
        num[p2] = pivot;
        quickSort(num, start, p2-1);
        quickSort(num, p2+1, end);
    }
	
	private static void qsort(int[] arr, int low, int high){
	    if (low < high){
	        int pivot=partition(arr, low, high);        //将数组分为两部分
	        qsort(arr, low, pivot-1);                   //递归排序左子数组
	        qsort(arr, pivot+1, high);                  //递归排序右子数组
	    }
	}
	private static int partition(int[] arr, int low, int high){
	    int pivot = arr[low];     //枢轴记录
	    while (low<high){
	        while (low<high && arr[high]>=pivot) --high;
	        arr[low]=arr[high];             //交换比枢轴小的记录到左端
	        while (low<high && arr[low]<=pivot) ++low;
	        arr[high] = arr[low];           //交换比枢轴小的记录到右端
	    }
	    //扫描完成，枢轴到位
	    arr[low] = pivot;
	    //返回的是枢轴的位置
	    return low;
	}
	
	public static void main(String[] args) {
		LongestConsecutive lc = new LongestConsecutive();
		int[] num = {1,2,0,1,3,5,2,1,5,6,7,8};
		System.out.println(lc.longestConsecutive(num));
	}
}
