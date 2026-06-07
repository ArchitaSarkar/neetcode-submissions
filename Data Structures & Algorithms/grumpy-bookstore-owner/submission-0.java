class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int res=0;
        for(int i=0;i<customers.length;i++)
        {
            if(grumpy[i]==0)
            {
                res+=customers[i];
            }
        }

        int extra=0;
        for(int i=0;i<minutes;i++)
        {
            if(grumpy[i]==1)
            {
                extra+=customers[i];
            }
        }
        int maxextra=extra;
        int l=0;
        int r=minutes-1;
        while(r<customers.length-1)
        {
            if(grumpy[l]==1)
            {
                extra-=customers[l];
            }
            l++;
            r++;
            if(grumpy[r]==1)
            {
                extra+=customers[r];
            }
            maxextra=Math.max(maxextra,extra);
        }

        return res+maxextra;
    }
}