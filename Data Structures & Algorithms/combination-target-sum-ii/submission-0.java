class Solution {
    public void util(int idx,int target,int[] nums,List<List<Integer>> res,List<Integer> l)
    {
       if(target==0)
       {
        res.add(new ArrayList<>(l));
        return;
       }
       if(idx>=nums.length) return;

       //pick
       int flag=0;
       if(nums[idx]<=target)
       {
        l.add(nums[idx]);
        flag=1;
        util(idx+1,target-nums[idx],nums,res,l);
       }
       int next=idx+1;
       while(next<nums.length && nums[next]==nums[idx])
       {
        next++;
       }

       if(flag==1 && l.size()>0) l.remove(l.size()-1);
       util(next,target,nums,res,l);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res=new ArrayList<>();
        Set<List<Integer>> set=new HashSet<>();
        util(0,target,candidates,res,new ArrayList<>());
        return res;
    }
}