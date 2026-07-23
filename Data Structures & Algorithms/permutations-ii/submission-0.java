class Solution {
    void util(int[] nums,boolean[] used,List<List<Integer>> res,List<Integer> curr)
    {
        if(curr.size()==nums.length)
        {
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0;i<nums.length;i++)
        {
            if(used[i]==true) continue;
            if(i>0 &&nums[i-1]==nums[i] && used[i-1]) continue;
            curr.add(nums[i]);
            used[i]=true;

            
            util(nums,used,res,curr);
            curr.remove(curr.size()-1);
            used[i]=false;
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        boolean used[]=new boolean[nums.length];
        util(nums,used,res,new ArrayList<>());
        return res;
    }
}