class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        int flag = 0;
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            int l1 = word1.length();
            int l2 = word2.length();
            int j = 0;
            flag = 0;
            while (j < l1 && j < l2) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);

                int rank1 = map.get(c1);
                int rank2 = map.get(c2);

                if (rank1 == rank2) {
                    j++;
                    continue;

                } else if (rank1 < rank2) {
                    flag = 1;
                    j++;
                    break;
                } else {
                    flag = 2;
                    j++;
                    break;
                }
                
            }
            if(flag==2) return false;
            if(flag==0)
            {
                if(l1>l2) return false;
            }

        }

        return true;
    }
}