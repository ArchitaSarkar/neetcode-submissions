class Solution {
    public int maxProfit(int[] prices) {
        int maxp=0;
        int profit=0;
        int i=0;
        int j=1;
        for(j=1;j<prices.length;j++){
            if(prices[j]<=prices[i])
            {
                i=j;
            }
            else
            {
                profit=prices[j]-prices[i];
                maxp=Math.max(maxp,profit);
            }
        }
        

        return maxp;
    }
}