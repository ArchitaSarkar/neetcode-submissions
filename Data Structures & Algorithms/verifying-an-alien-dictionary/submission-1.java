class Solution {

    public boolean isAlienSorted(String[] words, String order) {

        int[] rank = new int[26];

        for (int i = 0; i < order.length(); i++) {
            rank[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {

            String w1 = words[i];
            String w2 = words[i + 1];

            int j = 0;

            while (j < w1.length() && j < w2.length()) {

                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);

                int r1 = rank[c1 - 'a'];
                int r2 = rank[c2 - 'a'];

                if (r1 < r2) {
                    break;
                }

                else if (r1 > r2) {
                    return false;
                }

                j++;
            }

            // prefix case
            if (j == w2.length() && w1.length() > w2.length()) {
                return false;
            }
        }

        return true;
    }
}