class Solution {
    int sum=0;
    public void util(int[] nums,int idx,List<Integer> l)
    {
        if(idx>=nums.length)
        {
            int xor=0;
            for(int i=0;i<l.size();i++)
            {
                xor^=l.get(i);
            }
            sum+=xor;
            return;
        }

        //pick 
        l.add(nums[idx]);
        util(nums,idx+1,l);
        //notpick
        l.remove(l.size()-1);
        util(nums,idx+1,l);
    }
    public int subsetXORSum(int[] nums) {
        util(nums,0,new ArrayList<>());
        return sum;
    }
}