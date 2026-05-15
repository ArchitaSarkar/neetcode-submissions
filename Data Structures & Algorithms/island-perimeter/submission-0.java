class Solution {
    public int islandPerimeter(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int r[]={0,1,0,-1};
        int c[]={1,0,-1,0};

        int perimeter=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
              if(grid[i][j]==0) continue;
              for(int k=0;k<4;k++)
              {
                int nr=i+r[k];
                int nc=j+c[k];

                if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==1){
                    continue;
                }
                perimeter++;
              }
            }
        }
        return perimeter;
    }
}