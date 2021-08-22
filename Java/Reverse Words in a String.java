class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        String result = "";
        for (int i = words.length-1; i >= 0; i--) {
            if (!words[i].isEmpty()) {
                result = result + (words[i]) + " ";
            }
        }
        return result.trim();
    }
}
