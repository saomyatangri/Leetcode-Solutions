class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        int maxLen = 1;
        
        int left = 0;
        int right = 1;
        
        while (left < s.length()) {
            char leftChar = s.charAt(left);
            set.add(leftChar);
            if (right <= left) {
                right = left+1;
            }
            while (right < s.length() && set.add(s.charAt(right))) {
                right++;
            }
            maxLen = maxLen < set.size() ? set.size() : maxLen;
            set.remove(leftChar);
            left++;
        }
        
        return maxLen;
    }
}
