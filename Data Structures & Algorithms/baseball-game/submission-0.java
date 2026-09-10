class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<operations.length;i++)
        {
            String s=operations[i];
            if(s.equals("+"))
            {
                if(st.size()<2) continue;
                else
                {
                    int val1=st.pop();
                    int val2=st.pop();

                    int val3=val1+val2;

                    st.push(val2);
                    st.push(val1);
                    st.push(val3);
                }
            }
            else if(s.equals("D"))
            {
                if(st.isEmpty()) continue;
                else
                {
                    st.push(2*st.peek());
                }
            }
            else if(s.equals("C"))
            {
                if(st.isEmpty()) continue;
                else
                {
                    st.pop();
                }
            }
            else
            {
                st.push(Integer.parseInt(s));
            }
        }

        int ans=0;
        while(!st.isEmpty())
        {
            ans+=(int)st.pop();
        }
        return ans;
    }
}