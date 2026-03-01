class HitCounter {
    private static final int TIME_INTERVAL = 300;
    private final int[] hits;
    private final int[] times;

    public HitCounter() {
        hits = new int[TIME_INTERVAL];
        times = new int[TIME_INTERVAL];
    }
    
    public void hit(int timestamp) {
        int index = timestamp % TIME_INTERVAL;
        if (times[index] != timestamp) {
            hits[index] = 1;
            times[index] = timestamp;
        } else {
            hits[index]++;
        }
    }
    
    public int getHits(int timestamp) {
        int count = 0; 
        int floor = timestamp - TIME_INTERVAL;
        int ceil = timestamp;

        for (int i = 0; i < TIME_INTERVAL; i++) {
            if (times[i] > floor && times[i] <= ceil) {
                count += hits[i];
            }
        }
        return count;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
