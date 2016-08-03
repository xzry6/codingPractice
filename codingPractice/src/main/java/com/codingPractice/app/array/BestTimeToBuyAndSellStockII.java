package com.codingPractice.app.array;

public class BestTimeToBuyAndSellStockII {
	public int maxProfit(int[] prices) {
        if(prices.length<2) return 0;
        int min = prices[0];
        int last = prices[0];
        int pro = 0;
        for(int i=1; i<prices.length; ++i) {
        	if(prices[i]<last) {
        		pro += last-min;
            	min = prices[i];
        	}
        	last = prices[i];
        }
        return pro+last-min;
    }
}
