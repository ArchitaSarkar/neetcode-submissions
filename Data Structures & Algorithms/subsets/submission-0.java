class Solution {
    public void util(int idx,int[] nums,List<List<Integer>> res, List<Integer> l)
    {
        if(idx>=nums.length)
        {
            res.add(new ArrayList<>(l));
            return;
        }
        //pick
        l.add(nums[idx]);
        util(idx+1,nums,res,l);
        
        //notpick
        l.remove(l.size()-1);
        util(idx+1,nums,res,l);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        util(0,nums,res,new ArrayList<>());
        return res;
    }
}