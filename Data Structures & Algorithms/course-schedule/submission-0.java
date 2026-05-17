class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int V=numCourses;
       ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[]:prerequisites)
        {
            adj.get(edge[0]).add(edge[1]);
        }
        
        int[] indegree=new int[V];
        
        for(int i=0;i<adj.size();i++)
        {
            for(int next:adj.get(i)){
                indegree[next]++;
            }
        }
        
        Queue<Integer> q=new LinkedList<>();
        
        for(int i=0;i<V;i++)
        {
            if(indegree[i]==0) q.add(i);
        }
        
        int count=0;
        
        while(!q.isEmpty()){
            int curr=q.poll();
            count++;
            
            for(int next:adj.get(curr)){
                indegree[next]--;
                if(indegree[next]==0) q.add(next);
            }
        }
        
        return count==V;
    }
}