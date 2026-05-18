class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;

        for (int i = 0; i < m; i++) {
           
                if (grid[i][0] == 1) flood(grid, i, 0);
                if (grid[i][n-1] == 1) flood(grid, i, n-1);
            
        }
         for (int i = 0; i < n; i++) {
           
                if (grid[0][i] == 1) flood(grid, 0, i);
                if (grid[m-1][i] == 1) flood(grid, m-1, i);
            
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans += grid[i][j];
            }
        }

        return ans;
    }

    public void flood(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) return;

        grid[i][j] = 0;
        flood(grid, i + 1, j);
        flood(grid, i - 1, j);
        flood(grid, i, j + 1);
        flood(grid, i, j - 1);
    }
}