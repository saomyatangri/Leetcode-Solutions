class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, String> vals = new HashMap<>();
        vals.put(1, "I");
        vals.put(5, "V");
        vals.put(10, "X");
        vals.put(50, "L");
        vals.put(100, "C");
        vals.put(500, "D");
        vals.put(1000, "M");
        vals.put(4, "IV");
        vals.put(9, "IX");
        vals.put(40, "XL");
        vals.put(90, "XC");
        vals.put(400, "CD");
        vals.put(900, "CM");
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        
        while (num > 0) {
            int key = findBestFit(num, values);
            sb.append(vals.get(key));
            num-=key;
        }
        return sb.toString();
    }
    
    private int findBestFit(int num, int[] values) {
        for (int i = 0; i < values.length; i++) {
            if (num - values[i] >= 0) {
                return values[i];
            }
        }
        return -1; //should never hit this case
    }
}
