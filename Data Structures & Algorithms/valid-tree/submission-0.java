class Solution {
    public boolean validTree(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            list.get(u).add(v);
            list.get(v).add(u);
        }
        int vis[] = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                if (check(list, vis, i, -1) == true) {
                    return false;
                }
                count++;
            }
        }

        if (count > 1)
            return false;
        return true;
    }

    public boolean check(ArrayList<ArrayList<Integer>> list, int[] vis, int curr, int par) {
        vis[curr] = 1;
        for (int i = 0; i < list.get(curr).size(); i++) {
            int nb = list.get(curr).get(i);
            if (vis[nb] == 0) {
                if (check(list, vis, nb, curr) == true) {
                    return true;
                }
            } else {
                if (nb != par) {
                    return true;
                }
            }
        }
        return false;
    }
}
