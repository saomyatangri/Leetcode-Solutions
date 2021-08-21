class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> bannedMap = new HashSet<>();
        for (int i = 0; i < banned.length; i++) {
            bannedMap.add(banned[i]);
        }
        String newParagraph = paragraph.toLowerCase();
        HashMap<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < newParagraph.length(); i++) {
            char c = newParagraph.charAt(i);
            if (c >= 'a' && c <= 'z') {
                sb.append(c);
            } 
            if ((c == ' ' || c == '!' || c == '?' || c == '\'' || c == ',' || c == ';' || c == '.') && sb.length() != 0) {
                String word = sb.toString();
                if (map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                } else {
                    map.put(word, 1);
                }
                sb = new StringBuilder();
            }
        }
        if (sb.length() != 0) {
            String word = sb.toString();
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        int currMax = 0;
        String currWord = "";
        for (String key : map.keySet()) {
            if (!(bannedMap.contains(key)) && map.get(key) > currMax) {
                currMax = map.get(key);
                currWord = key;
            }
        }
        return currWord;
    }
}
