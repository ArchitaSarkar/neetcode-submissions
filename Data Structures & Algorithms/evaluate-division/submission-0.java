class Solution {
    class pair{
        String s;
        double value;
        pair(String s,double value){
            this.s=s;
            this.value=value;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String,List<pair>> adj=new HashMap<>();

        for(int i=0;i<equations.size();i++)
        {
            String u=equations.get(i).get(0);
            String v=equations.get(i).get(1);

            adj.putIfAbsent(u,new ArrayList<>());
            adj.putIfAbsent(v,new ArrayList<>());

            adj.get(u).add(new pair(v,values[i]));
            adj.get(v).add(new pair(u,1.0/values[i]));
        }

        int n=queries.size();

        double[] ans=new double[n];
        for(int i=0;i<n;i++)
        {
            String u=queries.get(i).get(0);
            String v=queries.get(i).get(1);

            if(!adj.containsKey(u) || !adj.containsKey(v))
            {
                ans[i]=-1.0;
            }
            else if(u.equals(v))
            {
                ans[i]=1.0;
            }
            else
            {
                Set<String> set =new HashSet<>();
                ans[i]=dfs(adj,set,u,v);
            }
        }
        return ans;
    }

    public double dfs(HashMap<String,List<pair>> adj,Set<String> set,String curr,String target){
        set.add(curr);
        if(curr.equals(target))
        {
            return 1.0;
        }

        for(pair p:adj.get(curr))
        {
            if(!set.contains(p.s))
            {
                double result= dfs(adj,set,p.s,target);
                if(result!=-1.0)
                {
                    return result*p.value;
                }
            }
        }
        return -1.0;
        
    }
}