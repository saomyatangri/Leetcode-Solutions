class Solution {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int max = len1 > len2 ? len1 : len2;
        if (len1 == 0) return num2;
        if (len2 == 0) return num1;
        
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        int[] output = new int[max+1];
        
        int p1 = len1-1; int p2 = len2-1; int p3 = max;
        boolean carry = false;
        
        for (int i = 0; i < max; i++) {
            int val1 = (p1 >= 0) ? n1[p1] - 48 : 0;
            int val2 = (p2 >= 0) ? n2[p2] - 48 : 0;
            int sum = val1+val2;
            sum = carry ? sum+1 : sum;
            output[p3] = sum%10;
            carry = (sum - 10) >= 0 ? true : false;
            p1--; p2--; p3--;
        }
        if (carry) output[p3] = 1;
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < output.length; i++) {
            if (i == 0 && output[0] == 0) continue;
            sb.append(output[i]);
        }
        return sb.toString();
    }
}
