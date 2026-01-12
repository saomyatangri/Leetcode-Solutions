/* originally had pairs as a local map defined inside isValid, after base solution passed refined to global instantiation for better cleanliness */
class Solution {
    private static final Map<Character, Character> PAIRS = Map.of(
    '(', ')',
    '[', ']',
    '{', '}');

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>(); 
        for (int i = 0; i < s.length(); i++) {
            Character curr = s.charAt(i);
            Character top = stack.peek();
            if (PAIRS.containsKey(curr)) {
                stack.push(curr);
            } else if (top != null && PAIRS.get(top) == curr) {
                stack.pop(); 
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
