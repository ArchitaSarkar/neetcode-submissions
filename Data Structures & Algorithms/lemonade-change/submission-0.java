class Solution {
    public boolean lemonadeChange(int[] bills) {
        int h5=0;
        int h10=0;
        int h20=0;
        for(int i=0;i<bills.length;i++)
        {
          //  int w=(bills[i]-5);
            if(bills[i]==5) h5++;
           else  if(bills[i]==10)
          {
             if(h5<1) return false;
             h10++;
             h5--;
          }
          else if(bills[i]==20)
          {
            if(!(h5>=3 || (h10>=1 && h5>=1)))
            {
                return false;
            }
            h20++;
            if(h10>=1 && h5>=1)
            {
                h5-=1;
                h10-=1;
            }
           else if(h5>=3) h5-=3;
            

          }
            
        }

        return true;
        
    }
}