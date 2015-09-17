best time to buy and sell stock II
/*
这里可以交易无限多次，既然次数没有限定，我们只要对每次两天差价大于0的都进行交易，就可以得到最大利润。如此只需要扫描一次就可以了，时间复杂度是O(n)，空间上只需要O(1)存一个累加结果即可。
参考：
http://codeganker.blogspot.com/2014/04/best-time-to-buy-and-sell-stock-ii.html
*/
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int profit = 0;
        for(int i = 0; i < prices.length-1; i++){
            if(prices[i] < prices[i+1]){
                profit += prices[i+1] - prices[i];
            }
        }
        return profit;
    }
}