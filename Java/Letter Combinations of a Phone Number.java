class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;
        
        Map<Integer, String[]> keypad = new HashMap<>();
        keypad.put(2, new String[]{"a", "b", "c"});
        keypad.put(3, new String[]{"d", "e", "f"});
        keypad.put(4, new String[]{"g", "h", "i"});
        keypad.put(5, new String[]{"j", "k", "l"});
        keypad.put(6, new String[]{"m", "n", "o"});
        keypad.put(7, new String[]{"p", "q", "r", "s"});
        keypad.put(8, new String[]{"t", "u", "v"});
        keypad.put(9, new String[]{"w", "x", "y", "z"});
        StringBuilder sb = new StringBuilder();
        makeCombos(result, digits, sb, keypad, 0);
        return result;
    }
    
    private void makeCombos(List<String> result, String digits, StringBuilder sb, Map<Integer, String[]> keypad, int currIndex) {
        if (currIndex == digits.length()) {
            result.add(sb.toString());
            sb = new StringBuilder();
            return;
        }
        System.out.println("currIndex: " + currIndex);
        int currNum = Character.getNumericValue(digits.charAt(currIndex));
        for (int j = 0; j < keypad.get(currNum).length; j++) {
            sb.append(keypad.get(currNum)[j]);
            makeCombos(result, digits, sb, keypad, currIndex+1);
            sb.deleteCharAt(currIndex);
        }
    }
}
