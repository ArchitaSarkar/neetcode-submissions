class Solution {
    public void result(int idx,int[] nums,List<List<Integer>> ans,List<Integer> list)
    {
        if(idx>=nums.length) 
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        
        list.add(nums[idx]);
        result(idx+1,nums,ans,list);

        int next=idx+1;
        while(next<nums.length && nums[next]==nums[idx])
        {
            next++;
        }
        list.remove(list.size()-1);
        result(next,nums,ans,list);

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
         List<List<Integer>>ans=new ArrayList<>();
         Arrays.sort(nums);
         result(0,nums,ans,new ArrayList<>());
         return ans;
    }
}