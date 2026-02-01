class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pk = new PriorityQueue(Collections.reverseOrder());
        for (int stone : stones) {
            pk.add(stone);
        }
        
        while (pk.size() > 1) {
            int y = pk.poll();
            int x = pk.poll();
            if (x != y) pk.add(y-x);
        }

        return pk.isEmpty() ? 0 : pk.poll();
    }
}
