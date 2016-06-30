package array;

public class BestTimeToBuyAndSellStockIII {
	public static int maxProfit(int[] prices) {
		if(prices.length<2) return 0;
        int min = prices[0];
		int pro = 0;
		int point = 0;
		int start = 0;
		int end = 0;
		for(int i=1; i<prices.length; ++i) {
			if(prices[i]<min) {
				min = prices[i];
				point = i;
			}
			if(prices[i]-min>pro) {
				pro = prices[i]-min;
				start = point;
				end = i;
			}
		}

		min = prices[start];
		int mid = 0;
		for(int i=start; i<=end; ++i) {
			min = Math.max(min, prices[i]);
			mid = Math.max(mid, min-prices[i]);
		}
		min = prices[0];
		int fir = 0;
		for(int i=0; i<start; ++i) {
			min = Math.min(min, prices[i]);
			fir = Math.max(fir, prices[i]-min);
		}
        min = prices[end];
		int sec = 0;
		for(int i=end+1; i<prices.length; ++i) {
			min = Math.min(min, prices[i]);
			sec = Math.max(sec, prices[i]-min);
		}
		sec = Math.max(fir, sec);
		return pro+Math.max(mid,sec); 
    }
	public static void main(String[] args) {
		int[] a = {1,7,4,2,11};
		System.out.println(maxProfit(a));
	}
}
