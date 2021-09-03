class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int firstOption = nums[len-1] * nums[len-2] * nums[len-3];
        int secOption = nums[0] * nums[1] * nums[len-1];
        return firstOption > secOption ? firstOption : secOption;
    }
}
