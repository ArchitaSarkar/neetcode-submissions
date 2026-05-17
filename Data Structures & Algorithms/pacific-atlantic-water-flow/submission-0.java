class Solution {
    int r[]={0,1,0,-1};
    int c[]={1,0,-1,0};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> list=new ArrayList<>();
        int n=heights.length;
        int m=heights[0].length;

        int[][] vis1=new int[n][m];
        int[][] vis2=new int[n][m];

        //pacific ocean
        for(int i=0;i<m;i++) dfs(vis1,heights,0,i);
        for(int i=0;i<n;i++) dfs(vis1,heights,i,0);
        //atlantic ocean
        for(int i=0;i<m;i++) dfs(vis2,heights,n-1,i);
        for(int i=0;i<n;i++) dfs(vis2,heights,i,m-1);

        

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(vis1[i][j]==1 && vis2[i][j]==1)
                {
                    list.add(Arrays.asList(i,j));
                }
            }
        }

        return list;
    }

    public void dfs(int[][] vis,int[][] heights,int row,int col)
    {
        if(vis[row][col]==1) return ;
        vis[row][col]=1;
        for(int i=0;i<4;i++)
        {
            int nr=row+r[i];
            int nc=col+c[i];

            if(nr>=0 && nr<heights.length && nc>=0 && nc<heights[0].length && heights[nr][nc]>=heights[row][col])
            {
               dfs(vis,heights,nr,nc);
            }
        }

    }
}