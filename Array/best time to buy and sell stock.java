best time to buy and sell stock
/*
这道题等价于在数组中找两个数的最大差，并且小的在大的前面
*/
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int min = Integer.MAX_VALUE, profit = 0;
        for(int i = 0; i < prices.length; i++){
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i] - min);
        }
        return profit;
    }
}