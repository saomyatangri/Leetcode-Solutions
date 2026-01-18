class Solution {
    public String removeDuplicates(String s) {
        if (s.length() <= 1) return s;
        Deque<Character> stack = new ArrayDeque<>();

        //remove duplicates
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (!stack.isEmpty() && stack.peek() == curr) {
                stack.pop();
            } else {
                stack.push(curr);
            }
        }

        //convert stack to string
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());
        return sb.reverse().toString();
    }
}
