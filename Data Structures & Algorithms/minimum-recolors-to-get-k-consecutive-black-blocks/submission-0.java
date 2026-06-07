class Solution {
    public int minimumRecolors(String blocks, int k) {
        int l=0;
        int r=k;
        int n=blocks.length();
        int op=0;
        for(int i=0;i<k;i++)
        {
            if(blocks.charAt(i)=='W')
            {
                op++;
            }
        }

        int minop=op;
        while(r<n)
        {
            if(blocks.charAt(r)=='B' && blocks.charAt(l)=='W')
            {
                op--;
                minop=Math.min(minop,op);
            }
            else if(blocks.charAt(r)=='W' && blocks.charAt(l)=='B')
            {
                op++; 
            }
            l++;
            r++;
        }

        return minop;
    }
}