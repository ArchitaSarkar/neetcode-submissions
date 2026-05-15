class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int [][] vis=new int[n][m];

        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]=='1' && vis[i][j]==0)
                {
                    dfs(i,j,vis,grid);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int row,int col,int[][] vis, char [][] grid)
    {
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length)
        {
            return;
        }
        if(grid[row][col]=='0' ||(grid[row][col]=='1' && vis[row][col]==1))
        {
            return;
        }

        vis[row][col]=1;
        dfs(row,col+1,vis,grid);
        dfs(row+1,col,vis,grid);
        dfs(row,col-1,vis,grid);
        dfs(row-1,col,vis,grid);

    }
}
