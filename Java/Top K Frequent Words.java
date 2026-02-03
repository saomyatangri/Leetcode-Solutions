class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0)+1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> {
            int compare = Integer.compare(map.get(a), map.get(b));
            if (compare == 0) return b.compareTo(a);
            return compare;
        });

        for (String key : map.keySet()) {
            pq.offer(key);
            if (pq.size() > k) pq.poll();
        }

        List<String> output = new ArrayList<>();
        while (!pq.isEmpty()) {
            output.add(pq.poll());
        }

        Collections.reverse(output);
        return output;
    }
}
