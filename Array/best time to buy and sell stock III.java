best time to buy and sell stock III
/*
两次交易的最大利润，可以理解为某个点的左右两侧分别存在一个最大值
一个数组从前往后记录min，和最大profit，另一个数组从后往前记录max和最大profit
最后两个数组加和中的最大值就是两次交易的最大利润
*/
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int min = prices[0], max = prices[prices.length - 1], maxprofit = 0;
        int[] profit1 = new int[prices.length], profit2 = new int[prices.length];
        profit1[0] = 0;
        for(int i = 1; i < prices.length; i++){
            min = Math.min(min, prices[i]);
            profit1[i] = Math.max(profit1[i-1], prices[i] - min);
        }
        for(int i = prices.length - 2; i >= 0; i--){
            max = Math.max(max, prices[i]);
            profit2[i] = Math.max(profit2[i+1], max - prices[i]);
        }
        for(int i = 0; i < prices.length; i++){
            profit1[i] += profit2[i];
            maxprofit = Math.max(maxprofit, profit1[i]);
        }
        return maxprofit;
    }
}