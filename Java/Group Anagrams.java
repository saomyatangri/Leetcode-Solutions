class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] tempArray = word.toCharArray();
            Arrays.sort(tempArray);
            String sortedWord = new String(tempArray);

            map.computeIfAbsent(sortedWord, k -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(map.values());
    }
}
