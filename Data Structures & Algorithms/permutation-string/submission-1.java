class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];

        int k = s1.length();
        int n = s2.length();

        if (k > n) return false;

        for (int i = 0; i < k; i++) {
            cnt1[s1.charAt(i) - 'a']++;
            cnt2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(cnt1, cnt2)) return true;

        for (int r = k; r < n; r++) {

            cnt2[s2.charAt(r) - 'a']++;

            cnt2[s2.charAt(r - k) - 'a']--;

            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }

        return false;
    }
}