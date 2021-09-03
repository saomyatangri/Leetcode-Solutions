class Solution {
    public void moveZeroes(int[] nums) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                q.add(i);
            }
        }
        

        for (int i = 0; i < nums.length; i++) {
            if (q.isEmpty()) {
                nums[i] = 0;
                continue;
            }
            int idx = q.remove();
            if (idx != i) {
                nums[i] = nums[idx];
            }
        }
    }
}

