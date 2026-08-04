class Solution {
    public int[] pivotArray(int[] nums, int pivot) {

        int less = 0;
        int equal = 0;

        for (int num : nums) {
            if (num < pivot)
                less++;
            else if (num == pivot)
                equal++;
        }

        int[] ans = new int[nums.length];

        int lp = 0;
        int ep = less;
        int gp = less + equal;

        for (int num : nums) {
            if (num < pivot)
                ans[lp++] = num;
            else if (num == pivot)
                ans[ep++] = num;
            else
                ans[gp++] = num;
        }

        return ans;
    }
}