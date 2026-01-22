class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        DFS(rooms, visited, 0);
        
        return allRoomsVisited(visited);
    }

    private void DFS(List<List<Integer>> rooms, boolean[] visited, int room) {
        visited[room] = true;
        
        for (int r : rooms.get(room)) {
            if (!visited[r]) DFS(rooms, visited, r);
        }
    }

    private boolean allRoomsVisited(boolean[] visited) {
        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }
        return true;
    }
}
