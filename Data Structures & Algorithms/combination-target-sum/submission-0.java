class Solution {
    public void util(int idx,int target,int[] nums,List<List<Integer>> res, List<Integer> l)
    {
        if(target==0)
        {
             res.add(new ArrayList<>(l));
             return;
        }
        if(idx>=nums.length)
        {
            return;
        }
        //pick
        int flag=0;
        if(nums[idx]<=target)
        {
            flag=1;
          l.add(nums[idx]);
          util(idx,target-nums[idx],nums,res,l);
        }
        
        
        //notpick
        if(flag==1 && l.size()>0) l.remove(l.size()-1);
        util(idx+1,target,nums,res,l);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        util(0,target,candidates,res,new ArrayList<>());
        return res;
    }
}