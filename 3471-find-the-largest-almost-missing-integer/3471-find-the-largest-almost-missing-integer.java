class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int[] count = new int[51];

        for (int i = 0; i <= n - k; i++) {
            boolean[] seen = new boolean[51];

            for (int j = i; j < i + k; j++) {
                if (!seen[nums[j]]) {
                    count[nums[j]]++;
                    seen[nums[j]] = true;
                }
            }
        }

        int ans = -1;

        for (int i = 50; i >= 0; i--) {
            if (count[i] == 1) {
                ans = i;
                break;
            }
        }

        return ans;
    }
}