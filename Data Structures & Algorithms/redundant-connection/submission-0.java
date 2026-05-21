class Solution {

    public int ultimateParent(int[] par,int n)
    {
        if(n==par[n]) return n;
        return par[n]=ultimateParent(par,par[n]);
    }

    
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        int parent[]=new int[n+1];
        int size[]=new int[n+1];
        int ans[]=new int[2];
        for(int i=1;i<=n;i++)
        {
            parent[i]=i;
            size[i]=1;
        }
         
        for(int[] edge:edges)
        {
            int u=edge[0];
            int v=edge[1];

            int up_u=ultimateParent(parent,u);
            int up_v=ultimateParent(parent,v);

            if(up_u==up_v)
            {
                ans[0]=u;
                ans[1]=v;

                return ans;
            }
            
            
            if(size[u]<size[v])
            {
               parent[up_u]=up_v;
               size[up_v]+=size[up_u];
            }
            else
            {
               parent[up_v]=up_u;
               size[up_u]+=size[up_v];
            }
        }

         return ans;
    }
}