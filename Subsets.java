class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        helper(nums, result, new ArrayList<Integer>(), 0);
        return result;
    }
    
    private void helper(int[] nums, List<List<Integer>> result, ArrayList<Integer> curr, int idx) {
        result.add(new ArrayList<Integer>(curr));
        
        for (int i = idx; i < nums.length; i++) {
            curr.add(nums[i]);
            helper(nums, result, curr, i+1);
            curr.remove(curr.size()-1);
        }
    }
}
