class Solution {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> ans = new ArrayList<>();

        // Special case
        if (n == 1) {
            ans.add(0);
            return ans;
        }

        // Graph
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Degree array
        int[] degree = new int[n];

        // Build graph
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);

            degree[u]++;
            degree[v]++;
        }

        // Queue for leaves
        Queue<Integer> q = new LinkedList<>();

        // Add all leaves
        for (int i = 0; i < n; i++) {

            if (degree[i] == 1) {
                q.offer(i);
            }
        }

        int remainingNodes = n;

        // Remove leaves level by level
        while (remainingNodes > 2) {

            int size = q.size();

            remainingNodes -= size;

            for (int i = 0; i < size; i++) {

                int leaf = q.poll();

                for (int neighbor : adj.get(leaf)) {

                    degree[neighbor]--;

                    // New leaf formed
                    if (degree[neighbor] == 1) {
                        q.offer(neighbor);
                    }
                }
            }
        }

        // Remaining nodes are answers
        while (!q.isEmpty()) {
            ans.add(q.poll());
        }

        return ans;
    }
}