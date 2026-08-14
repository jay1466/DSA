class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res=new int[2];
    for(int i=1;i<nums.length;i++){
        for(int j=0;j+i<nums.length;j++){
            if(nums[j]+nums[j+i]==target){
                res[0]=j;
                res[1]=j+i;
                return res;
            }
        }
    }
        return res;
    }
}