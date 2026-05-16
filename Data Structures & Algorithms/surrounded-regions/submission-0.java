class Solution {
    static class item{
        int row;
        int col;
        item(int row,int col)
        {
            this.row=row;
            this.col=col;
        }
    }
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        int vis[][]=new int [m][n];
        Queue<item> q=new LinkedList<>();
        //top 
        for(int i=0;i<n;i++)
        {
            if(board[0][i]=='O')
            {
                q.add(new item(0,i));
            }
        }
         //bottom 
        for(int i=0;i<n;i++)
        {
            if(board[m-1][i]=='O')
            {
                q.add(new item(m-1,i));
            }
        } //right 
        for(int i=0;i<m;i++)
        {
            if(board[i][n-1]=='O')
            {
                q.add(new item(i,n-1));
            }
        } //left 
        for(int i=0;i<m;i++)
        {
            if(board[i][0]=='O')
            {
                q.add(new item(i,0));
            }
        }
        int r[]={-1,0,1,0};
        int c[]={0,1,0,-1};
        while(!q.isEmpty())
        {
            item it=q.poll();
            vis[it.row][it.col]=1;
            for(int i=0;i<4;i++)
            {
                int nr=it.row+ r[i];
                int nc=it.col+c[i];
                if(nr>=0 && nr<m && nc>=0 && nc<n && board[nr][nc]=='O'&& vis[nr][nc]!=1)
                {
                    q.add(new item(nr,nc));
                    vis[nr][nc]=1;
                }
            }
        }

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]=='O' && vis[i][j]==0)
                {
                    board[i][j]='X';
                }
            }
        }

    }
}