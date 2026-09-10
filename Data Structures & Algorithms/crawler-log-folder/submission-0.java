class Solution {
    public int minOperations(String[] logs) {
        int stack = 0;

        for (String log : logs) {
            if (log.equals("../")) {
                if (stack > 0) stack--;
            }
            else if (log.equals("./")) {
                continue;
            } else {
                stack++;
            }
        }

        return stack;
    }
}