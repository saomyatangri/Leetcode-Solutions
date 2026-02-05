class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> {
            // Use squared distance instead of Euclidean distance
            // sqrt() is monotonic so it doesn't affect ordering
            int da = (a[0]*a[0]) + (a[1]*a[1]);
            int db = (b[0]*b[0]) + (b[1]*b[1]);
            return Integer.compare(db, da);
        });

        for (int[] point : points) {
            pq.offer(point);
            if (pq.size() > k) pq.poll();
        }

        int[][] output = new int[k][2];
        int i = 0;
        while (!pq.isEmpty()) {
            output[i] = pq.poll();
            i++;
        }

        return output;
    }
}
