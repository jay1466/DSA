class Solution {
    public int missingNumber(int[] nums) {
        int xor1 = 0;
        int xor2 = 0;

        for (int i =0; i<nums.length; i++){
            xor2 = xor2^nums[i];
            xor1 = xor1^(i);
        }
        xor1 = xor1 ^ nums.length;
        return xor1^xor2;
}
}