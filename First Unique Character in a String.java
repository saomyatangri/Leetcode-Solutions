class Solution {
    public int firstUniqChar(String s) {
        //Time efficiency: O(N)
        //Space efficiency: O(1), both HashMap and HashSet will have a max size of 26
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        HashSet<Character> alreadyChecked = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!(alreadyChecked.contains(c)) && map.containsKey(c) && map.get(c) == i) {
                return i;
            } else {
                alreadyChecked.add(c);
            }
        }
        return -1;
    }
}
