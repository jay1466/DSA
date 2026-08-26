class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();

        // Store positions of all 1s
        int[] ones = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                ones[count++] = i;
            }
        }

        // Not enough 1s
        if (count < k) {
            return "";
        }

        String ans = "";
        int minLength = Integer.MAX_VALUE;

        // Check every group of k consecutive 1s
        for (int i = 0; i + k - 1 < count; i++) {
            int start = ones[i];
            int end = ones[i + k - 1];

            int length = end - start + 1;

            String current = s.substring(start, end + 1);

            if (length < minLength) {
                minLength = length;
                ans = current;
            } 
            else if (length == minLength && current.compareTo(ans) < 0) {
                ans = current;
            }
        }

        return ans;
    }
}