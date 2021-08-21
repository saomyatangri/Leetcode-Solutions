class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        permutations(result, new ArrayList<Integer>(), nums);
        return result;
    }
    
    private void permutations(List<List<Integer>> result, ArrayList<Integer> curr, int[] nums) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList<Integer>(curr));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!curr.contains(nums[i])) {
                curr.add(nums[i]);
                permutations(result, curr, nums);
                curr.remove(curr.size()-1);
            }
        }
    }
}
