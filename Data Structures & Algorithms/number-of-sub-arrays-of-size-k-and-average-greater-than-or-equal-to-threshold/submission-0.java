class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int l=0;
        int r=k-1;
        int count=0;
        int sum=0;
        for(int i=0;i<k;i++)
        {
            sum+=arr[i];
        }

        double avg=sum/k;
        if(avg>=threshold) count++;
        while(r<arr.length-1)
        {
            sum-=arr[l];
            l++;
            r++;
            sum+=arr[r];
            avg=sum/k;
            if(avg>=threshold) count++;
        }

        return count;
    }
}