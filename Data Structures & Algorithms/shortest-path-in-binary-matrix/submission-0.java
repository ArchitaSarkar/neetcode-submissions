class Solution {
    class pair{
        int row;
        int col;
        int path;
        pair(int row,int col,int path)
        {
            this.row=row;
            this.col=col;
            this.path=path;

        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int vis[][]=new int[n][n];
        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(0,0,1));
        vis[0][0]=1;
        int r[]={0,1,1,1,0,-1,-1,-1};
        int c[]={1,1,0,-1,-1,-1,0,1};
        while(!q.isEmpty())
        {
          pair p=q.poll();
          int row=p.row;
          int col=p.col;
          int path=p.path;
          if(row==n-1 && col==n-1) return path;
          for(int i=0;i<8;i++)
          {
            int nr=row+r[i];
            int nc=col+c[i];

            if(nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc]==0 && vis[nr][nc]==0)
            {
                vis[nr][nc]=1;
                q.add(new pair(nr,nc,path+1));
            }
          }
          
        }

        return -1;
    }
}