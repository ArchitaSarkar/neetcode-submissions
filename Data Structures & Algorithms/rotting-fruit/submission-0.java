class Solution {
    class Triplate {
        int row;
        int col;
        int time;

        Triplate(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public int orangesRotting(int[][] grid) {
        int count=0;
        Queue<Triplate> q=new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==2)
                {
                    q.add(new Triplate(i,j,0));
                    vis[i][j]=1;
                }

            }
        }
        
        int r[]={0,1,0,-1};
        int c[]={1,0,-1,0};

        while(!q.isEmpty())
        {
            Triplate t=q.poll();
            int row=t.row;
            int col=t.col;
            int time=t.time;

            for(int i=0;i<4;i++)
            {
                int nr=row+r[i];
                int nc=col+c[i];

                if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==1 && vis[nr][nc]==0)
                {
                    vis[nr][nc]=1;
                    q.add(new Triplate(nr,nc,time+1));
                    count=Math.max(count,time+1);
                }


            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
            {
                if(vis[i][j]==0 && grid[i][j]==1)
                {
                    return -1;
                }
            }
        }

        return count;
    }
}