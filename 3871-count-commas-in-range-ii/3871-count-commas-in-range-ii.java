class Solution {
    public long countCommas(long n) {
        long ans = 0;

        for (long power = 1000; power <= n; power *= 1000) {
            ans += n - power + 1;

            if (power > n / 1000) {
                break;
            }
        }

        return ans;
    }
}