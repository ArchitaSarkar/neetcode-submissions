class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int[] vis=new int[n];
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(vis[i]==0){
                dfs(i,isConnected,vis);
                count++;
            }
        }
        return count;
    }

    public void dfs(int curr,int[][] isConnected,int[] vis)
    {
        vis[curr]=1;
        for(int i=0;i<isConnected.length;i++)
        {
            if(isConnected[curr][i]==1 && vis[i]==0)
            {
                vis[i]=1;
                dfs(i,isConnected,vis);
            }
        }
    }
}