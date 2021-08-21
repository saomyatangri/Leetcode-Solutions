class Solution {
    public int climbStairs(int n) {
        //this is basically fibonacci
        int[] memo = new int[n+1];
        return fibonacci(n, memo);
    }
    
    private int fibonacci(int n, int[] memo) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (memo[n] != 0) return memo[n];
        memo[n] += fibonacci(n-1, memo) + fibonacci(n-2, memo);
        return memo[n];
    }
}
