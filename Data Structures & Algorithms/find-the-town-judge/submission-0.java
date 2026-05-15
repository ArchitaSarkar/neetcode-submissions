class Solution {
    public int findJudge(int n, int[][] trust) {
        ArrayList<ArrayList<Integer>> list =new ArrayList<>();
        for(int i=0;i<n+1;i++){
            list.add(new ArrayList<>());
        }

        for(int[] edge:trust)
        {
            list.get(edge[0]).add(edge[1]);
        }
        
        int judge=-1;
        for(int i=1;i<n+1;i++)
        {
            if(list.get(i).isEmpty())
            {
                judge=i;
                break;
            }
        }
        if(judge==-1) return -1;

        for(int i=1;i<n+1;i++)
        {
            if(i==judge) continue;
            if(!(list.get(i).contains(judge))) return -1;
        }
        return judge;
    }
}