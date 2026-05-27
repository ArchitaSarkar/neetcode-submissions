class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int total=prices[0]+prices[1];
        return ((money-total)>=0)?(money-total):money;
    }
}