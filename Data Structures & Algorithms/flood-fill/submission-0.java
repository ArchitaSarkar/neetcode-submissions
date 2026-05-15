class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int inicol=image[sr][sc];
        if(color==inicol) return image;

        dfs(sr,sc,color,inicol,image);

        return image;
    }

    public void dfs(int row,int col,int color,int inicol,int[][] image)
    {
        if(row<0 || row>=image.length || col<0 || col>=image[0].length){
            return;
        }
        if (image[row][col]!=inicol)
        {
           return;
        }
        
         image[row][col]=color;
         
        dfs(row,col+1,color,inicol,image);
        dfs(row+1,col,color,inicol,image);
        dfs(row,col-1,color,inicol,image);
        dfs(row-1,col,color,inicol,image);
    }
}