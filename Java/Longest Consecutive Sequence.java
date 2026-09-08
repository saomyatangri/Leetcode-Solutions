class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 1;
        for (int num : set) {
            if (!set.contains(num-1)) {
                int current = 1; int counter = 1;
            
                while (set.contains(num+counter)) {
                    current++; counter++;
                }
                if (current > longest) longest = current;    
            }
        }
        return longest;
    }
}
