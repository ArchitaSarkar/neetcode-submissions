class Solution {

    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public void dfs(int[][] grid, boolean[][] vis,
                    Queue<Pair> q, int row, int col) {

        int n = grid.length;

        if (row < 0 || row >= n || col < 0 || col >= n
                || vis[row][col]
                || grid[row][col] == 0) {
            return;
        }

        vis[row][col] = true;

        q.add(new Pair(row, col));

        for (int i = 0; i < 4; i++) {
            dfs(grid, vis, q,
                    row + dr[i],
                    col + dc[i]);
        }
    }

    public int shortestBridge(int[][] grid) {

        int n = grid.length;

        boolean[][] vis = new boolean[n][n];

        Queue<Pair> q = new LinkedList<>();

        boolean found = false;

        // Find first island
        for (int i = 0; i < n; i++) {

            if (found)
                break;

            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {

                    dfs(grid, vis, q, i, j);

                    found = true;
                    break;
                }
            }
        }

        int level = 0;

        // Multi-source BFS
        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                Pair curr = q.poll();

                for (int i = 0; i < 4; i++) {

                    int nr = curr.row + dr[i];
                    int nc = curr.col + dc[i];

                    if (nr < 0 || nr >= n
                            || nc < 0 || nc >= n
                            || vis[nr][nc]) {
                        continue;
                    }

                    // Reached second island
                    if (grid[nr][nc] == 1) {
                        return level;
                    }

                    vis[nr][nc] = true;

                    q.add(new Pair(nr, nc));
                }
            }

            level++;
        }

        return -1;
    }
}