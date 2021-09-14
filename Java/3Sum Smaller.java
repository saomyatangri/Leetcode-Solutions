class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int len = nums.length;
        if (len < 3) return 0;
        
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < len-2; i++) {
            int left = i+1;
            int right = len-1;
            while (left < right) {
                int sum = nums[i]+nums[left]+nums[right];
                if (sum < target) {
                    count+=(right-left);
                    left++;
                } else {
                    right--;
                }
            }
        }
        return count;
    }
}
