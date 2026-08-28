class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();

        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        int odd = 0;
        int middle = -1;

        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 == 1) {
                odd++;
                middle = i;
            }
        }

        if (odd > 1) {
            return "";
        }

        int halfLen = n / 2;
        int prefixLen = (n + 1) / 2;

        int[] available = new int[26];

        for (int i = 0; i < 26; i++) {
            available[i] = count[i] / 2;
        }

        char[] prefix = new char[prefixLen];

        for (int i = 0; i < halfLen; i++) {
            int t = target.charAt(i) - 'a';

            if (available[t] == 0) {
                for (int c = t + 1; c < 26; c++) {
                    if (available[c] > 0) {
                        prefix[i] = (char) ('a' + c);
                        available[c]--;

                        fillSmallest(prefix, i + 1, available);

                        if (n % 2 == 1) {
                            prefix[prefixLen - 1] = (char) ('a' + middle);
                        }

                        return buildPalindrome(prefix, n);
                    }
                }

                return backtrack(prefix, i, available, middle, n);
            }

            prefix[i] = (char) ('a' + t);
            available[t]--;
        }

        if (n % 2 == 1) {
            prefix[prefixLen - 1] = (char) ('a' + middle);
        }

        String candidate = buildPalindrome(prefix, n);

        if (candidate.compareTo(target) > 0) {
            return candidate;
        }

        return backtrack(prefix, halfLen, available, middle, n);
    }

    private String backtrack(
        char[] prefix,
        int pos,
        int[] available,
        int middle,
        int n
    ) {
        for (int i = pos - 1; i >= 0; i--) {
            available[prefix[i] - 'a']++;

            int current = prefix[i] - 'a';

            for (int c = current + 1; c < 26; c++) {
                if (available[c] > 0) {
                    prefix[i] = (char) ('a' + c);
                    available[c]--;

                    fillSmallest(prefix, i + 1, available);

                    if (n % 2 == 1) {
                        prefix[prefix.length - 1] =
                            (char) ('a' + middle);
                    }

                    return buildPalindrome(prefix, n);
                }
            }
        }

        return "";
    }

    private void fillSmallest(
        char[] prefix,
        int start,
        int[] available
    ) {
        for (int i = start; i < prefix.length; i++) {
            for (int c = 0; c < 26; c++) {
                if (available[c] > 0) {
                    prefix[i] = (char) ('a' + c);
                    available[c]--;
                    break;
                }
            }
        }
    }

    private String buildPalindrome(char[] prefix, int n) {
        StringBuilder ans = new StringBuilder();

        for (char c : prefix) {
            ans.append(c);
        }

        int start = n % 2 == 1
            ? prefix.length - 2
            : prefix.length - 1;

        for (int i = start; i >= 0; i--) {
            ans.append(prefix[i]);
        }

        return ans.toString();
    }
}