class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0)+1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> {
            int compareFreq = Integer.compare(freqMap.get(a), freqMap.get(b));
            if (compareFreq != 0) return compareFreq;
            return b.compareTo(a);
        });

        for (String word : freqMap.keySet()) {
            pq.offer(word);
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
