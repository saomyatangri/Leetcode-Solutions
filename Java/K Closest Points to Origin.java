class Solution {
    public int[][] kClosest(int[][] points, int K) {
        TreeMap<Double, ArrayList<int[]>> map = new TreeMap<>();
        for (int[] coordinate : points) {
            int x = coordinate[0];
            int y = coordinate[1];
            double distance = Math.sqrt((x*x)+(y*y));
            if (map.containsKey(distance)) {
                map.get(distance).add(coordinate);
            } else {
                ArrayList<int[]> temp = new ArrayList<>();
                temp.add(coordinate);
                map.put(distance, temp);
            }
        }
        
        int[][] result = new int[K][2];
        int index = 0;

        for (double key : map.keySet()) {
            for (int i = 0; i < map.get(key).size(); i++) {
                if (index == K) break;
                result[index] = map.get(key).get(i);
                index++;
            }
            
        }
        return result;
    }
}
