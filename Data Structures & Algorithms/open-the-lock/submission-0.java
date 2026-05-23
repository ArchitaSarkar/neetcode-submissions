class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadlist =new HashSet<>(Arrays.asList(deadends));

        if(deadlist.contains("0000")) return -1;
        Set<String> vis=new HashSet<>();
        Queue<String> q=new LinkedList<>();
        q.add("0000");
        vis.add("0000");
        int move=0;
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                String curr=q.poll();
                if(curr.equals(target)) return move;
                for(String nei: neighbour(curr))
                {
                    if(!deadlist.contains(nei) && !vis.contains(nei))
                    {
                        q.add(nei);
                        vis.add(nei);
                    }
                }
            }
            move++;
        }
        return -1;
    }

    public List<String> neighbour(String curr)
    {
        List<String> list=new ArrayList<>();
        char[] arr=curr.toCharArray();
        for(int i=0;i<4;i++)
        {
            char ch=arr[i];

            //forward
            arr[i]=(ch=='9')?'0':(char)(ch+1);
            list.add(new String(arr));

            //backward
            arr[i]=(ch=='0')?'9':(char)(ch-1);
            list.add(new String(arr));

            arr[i]=ch;
        }

        return list;
    }
}