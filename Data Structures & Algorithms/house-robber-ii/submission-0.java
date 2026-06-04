class Solution {
     public int calc(int[] nums,int idx,int[] dp,int s)
    {
        if(idx==s) return nums[idx];
        if(idx<s) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int pick=nums[idx]+calc(nums,idx-2,dp,s);
        int npick=0+calc(nums,idx-1,dp,s);

        return dp[idx]=Math.max(pick,npick);
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        int l=calc(nums,n-2,dp,0);
        Arrays.fill(dp,-1);
        int r=calc(nums,n-1,dp,1);

        return (int)Math.max(l,r);
    }
}