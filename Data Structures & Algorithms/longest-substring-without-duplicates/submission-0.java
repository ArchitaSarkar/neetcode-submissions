class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0;
        int r=0;
        int maxlen=0;
        int n=s.length();
        HashMap<Character,Integer> st=new HashMap<Character,Integer>();
        
        while(r<n)
        {
           if(st.containsKey(s.charAt(r)))
           {
             l=Math.max(st.get(s.charAt(r))+1,l);
           }
          
            st.put(s.charAt(r),r);
            maxlen=Math.max(maxlen,r-l+1);
            r++;
         
        }

        return maxlen;
    }
}