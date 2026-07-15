class Solution {
    public int missingNumber(int[] nums) {
        int total_sum =0;
        int arr_sum = 0;
        for(int i=0; i<=nums.length; i++){
            total_sum +=i;
            if(i!=nums.length)
              arr_sum += nums[i];
        }
        return total_sum - arr_sum;
    }
}