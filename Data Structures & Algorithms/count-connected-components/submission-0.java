class Solution {
    public int countComponents(int n, int[][] edges) {
    ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    for(int i=0;i<n;i++){
        adj.add(new ArrayList<>());
    }
    for(int edge[]:edges)
    {
        adj.get(edge[0]).add(edge[1]);
        adj.get(edge[1]).add(edge[0]);
    }
    int vis[]=new int[n];
    int count=0;
    for(int i=0;i<n;i++)
    {
        if(vis[i]==0)
        {
            dfs(adj,vis,i);
            count++;
        }
    }
    return count;
    }

    public void dfs(ArrayList<ArrayList<Integer>> list,int[] vis,int curr)
    {
        vis[curr]=1;
        for(int i=0;i<list.get(curr).size();i++)
        {
            int nb=list.get(curr).get(i);
            if(vis[nb]==0)
            {
                dfs(list,vis,nb);
            }
        }
    }
}
