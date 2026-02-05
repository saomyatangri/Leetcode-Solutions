class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> {
            double adiv = (double)a[0]/a[1];
            double bdiv = (double)b[0]/b[1];
            return Double.compare(bdiv, adiv);
        }); 
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                pq.offer(new int[] {arr[i], arr[j]});
                if (pq.size() > k) pq.poll();
            }
        }
        
        return pq.poll();
    }
}
