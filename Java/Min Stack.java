class MinStack {
    
    private Deque<Integer> stack;
    private Deque<Integer> mins;

    
    public MinStack() {
         stack = new ArrayDeque<>();
         mins = new ArrayDeque<>();
    }
    
    public void push(int val) {
        //System.out.printf("push before, val = %d, mins: %s\n", val, mins);
        stack.push(val);
        if (mins.isEmpty() || val <= mins.peek()) {
            mins.push(val);
        }
        //System.out.printf("push after, val = %d, mins: %s\n", val, mins);
    }
    
    public void pop() {        
        int val = stack.pop();
        //System.out.printf("pop before, val = %d, mins: %s\n", val, mins);
        if (mins.peek() == val) {
            mins.pop();
        }
        //System.out.printf("pop before, val = %d, mins: %s\n", val, mins);
    }
    
    public int top() {
        return stack.peek();
        
    }
    
    public int getMin() {
        return mins.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
