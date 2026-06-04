class Solution {
    public int calc(int[] nums,int idx,int[] dp)
    {
        if(idx==0) return nums[idx];
        if(idx<1) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int pick=nums[idx]+calc(nums,idx-2,dp);
        int npick=0+calc(nums,idx-1,dp);

        return dp[idx]=Math.max(pick,npick);
    }
    public int rob(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n+1];
        for(int i=0;i<=n;i++)
        {
            dp[i]=-1;
        }
        return calc(nums,n-1,dp);
    }
}