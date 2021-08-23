class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.out.println(s);
        
        int len = s.length();
        for (int i = 0; i < len/2; i++) {
            if (s.charAt(i) != s.charAt(len-(i+1))) {
                return false;
            }
        }
        return true;
    }
}
