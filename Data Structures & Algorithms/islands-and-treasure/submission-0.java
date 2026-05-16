class Solution {
    class triplate {
        int row;
        int col;
        int time;
        triplate(int row,int col,int time){
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }
    public void islandsAndTreasure(int[][] grid) {
        PriorityQueue<triplate> q=new PriorityQueue<>((a,b)->a.time-b.time);
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==0)
                {
                    q.add(new triplate(i,j,0));
                }
            }
        }

        int r[]={0,1,0,-1};
        int c[]={1,0,-1,0};
        while(!q.isEmpty())
        {
            triplate t= q.poll();
            int row=t.row;
            int col=t.col;
            int time=t.time;
            
            for(int i=0;i<4;i++)
            {
                int nr=row+r[i];
                int nc=col+c[i];

                if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==2147483647)
                {
                    grid[nr][nc]=time+1;
                    q.add(new triplate(nr,nc,time+1));
                }
            }
        }

        
    }
}
