class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int front = 0;
        int back = numbers.length - 1;
        while (front < back) {
            int sum = numbers[front] + numbers[back];           
            if (sum == target) {
                //Success case!
                return new int[]{front + 1, back + 1};
            } else if (sum > target) {
                back--;
            } else {
                front++;
            }
        }
        throw new IllegalArgumentException("Illegal inputs, must have solution");
    }
}
