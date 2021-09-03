class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];
        for (int i = 0; i < updates.length; i++) {
            int start = updates[i][0];
            int end = updates[i][1];
            int val = updates[i][2];
            
            result[start] += val;
            if (end < length-1) {
                result[end+1] -= val;
            }
        }
        
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += result[i];
            result[i] = sum;
        }
        return result;
    }   
}

// less efficient, but the first thing that came to mind for me
/*
class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            int iter_outcome = 0;
            for (int j = 0; j < updates.length; j++) {
                if (updates[j][0] <= i && updates[j][1] >= i) {
                    iter_outcome += updates[j][2];
                }
            }
            result[i] = iter_outcome;
        }
        return result;
    }
}
*/
