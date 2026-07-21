class Solution {
    public void util(int idx,int k,int n,List<List<Integer>> res,List<Integer> l)
    {
        if(k==0)
        {
            res.add(new ArrayList<>(l));
            return;
        }
        if(idx>=n) return;

        l.add(idx+1);
        util(idx+1,k-1,n,res,l);

        l.remove(l.size()-1);
        util(idx+1,k,n,res,l);
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        util(0,k,n,res,new ArrayList<>());
        return res;
    }
}