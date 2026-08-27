class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();

        for (int i = n - 1; i >= 0; i--) {
            int[] freq = new int[26];

            for (char c : s.toCharArray()) {
                freq[c - 'a']++;
            }

            boolean possible = true;

            for (int j = 0; j < i; j++) {
                int x = target.charAt(j) - 'a';

                if (freq[x] == 0) {
                    possible = false;
                    break;
                }

                freq[x]--;
            }

            if (!possible) {
                continue;
            }

            int x = target.charAt(i) - 'a';

            for (int c = x + 1; c < 26; c++) {
                if (freq[c] > 0) {
                    StringBuilder ans = new StringBuilder();

                    ans.append(target, 0, i);
                    ans.append((char) ('a' + c));
                    freq[c]--;

                    for (int k = 0; k < 26; k++) {
                        while (freq[k] > 0) {
                            ans.append((char) ('a' + k));
                            freq[k]--;
                        }
                    }

                    return ans.toString();
                }
            }
        }

        return "";
    }
}