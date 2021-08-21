class Solution {
    public void reverseString(char[] s) {
        int len = s.length;
        boolean isEven = len%2 == 0 ? true : false;
        for (int i = 0; i < len/2; i++) {
            char firstChar = s[i];
            char lastChar = s[len-(i+1)];
            
            s[i] = lastChar;
            s[len-(i+1)] = firstChar;
        }
    }
}
