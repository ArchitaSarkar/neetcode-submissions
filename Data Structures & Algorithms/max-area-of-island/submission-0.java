class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int count[]=new int[1];
        int n=grid.length;
        int m=grid[0].length;

        int [][] vis=new int[n][m];
        int maxArea=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1 && vis[i][j]==0)
                {
                    dfs(i,j,vis,grid,count);
                    maxArea=Math.max(maxArea,count[0]);
                    count[0]=0;
                    
                }
            }
        }
        return maxArea;

        
    }

     public void dfs(int row,int col,int[][] vis, int [][] grid,int[] count)
    {
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length)
        {
            return;
        }
        if(grid[row][col]==0 ||(grid[row][col]==1 && vis[row][col]==1))
        {
            return;
        }

        vis[row][col]=1;
        count[0]++;
        dfs(row,col+1,vis,grid,count);
        dfs(row+1,col,vis,grid,count);
        dfs(row,col-1,vis,grid,count);
        dfs(row-1,col,vis,grid,count);

    }
}
