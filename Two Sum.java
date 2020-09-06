class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int result[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int goal = target - nums[i];
            if (map.containsKey(goal) && map.get(goal) != i) {
                result[0] = i;
                result[1] = map.get(goal);
                return result;
            }
        }
        return result;
    }
}
