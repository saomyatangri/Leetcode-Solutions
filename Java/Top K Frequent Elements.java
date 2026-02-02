class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (map.containsKey(curr)) {
                map.put(curr, map.get(curr)+1);
            } else {
                map.put(curr, 1);
            }
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue((a,b) -> map.get(a)-map.get(b));
        for (int key : map.keySet()) {
            pq.offer(key);
            if (pq.size() > k) pq.poll();
        }

        int[] output = new int[pq.size()];
        int idx = 0;
        while (!pq.isEmpty()) {
            output[idx] = pq.poll();
            idx++;
        }

        return output;
    }
}
