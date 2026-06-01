class Solution {
    int two=Integer.MAX_VALUE;
    public int res(int idx,int[] cost,int[] dp)
    {
        if(idx<=1) return 0;
        if(dp[idx]!=-1) return dp[idx];

        int one=cost[idx-1]+res(idx-1,cost,dp);
        if(idx-2>=0)
         two=cost[idx-2]+res(idx-2,cost,dp);

        return dp[idx]=Math.min(one,two);
    }
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp=new int[n+1];
        for(int i=0;i<=n;i++)
        {
            dp[i]=-1;
        }

        return res(n,cost,dp);
    }
}
