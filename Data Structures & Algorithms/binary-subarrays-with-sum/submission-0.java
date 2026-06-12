class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer,Integer> freq=new HashMap<>();
        freq.put(0,1);
        int count=0;
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            int num=nums[i];
            sum+=num;
            if(freq.containsKey(sum-goal))
            {
                int f=freq.get(sum-goal);
                count+=f;
            }
            freq.put(sum,freq.getOrDefault(sum,0)+1);
        }
        return count;
    }
}