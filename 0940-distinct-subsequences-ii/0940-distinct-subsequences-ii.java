class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;

        long[] end = new long[26];
        long total = 0;

        for (char c : s.toCharArray()) {
            int idx = c - 'a';

            long newSubseq = (total + 1) % MOD;

            total = (total - end[idx] + MOD) % MOD;

            end[idx] = newSubseq;

            total = (total + newSubseq) % MOD;
        }

        return (int) total;
    }
}