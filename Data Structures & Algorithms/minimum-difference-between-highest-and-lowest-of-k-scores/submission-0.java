
class Solution {
    public int minimumDifference(int[] nums, int k) {
        // Edge case
        if (k <= 1) return 0;

        Arrays.sort(nums);  // Step 1: sort

        int minDiff = Integer.MAX_VALUE;

        // Step 2: sliding window of size k
        for (int i = 0; i <= nums.length - k; i++) {
            int diff = nums[i + k - 1] - nums[i];
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }
}