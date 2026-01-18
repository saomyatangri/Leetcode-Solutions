class Solution {
    private static final int[][] DIRS = {{1,0}, {0,1}, {-1,0}, {0,-1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;
        Queue<int[]> queue = new ArrayDeque<>();
        int rows = image.length, cols = image[0].length;

        //save color to be modified
        int original = image[sr][sc];
        //add current pixel to be visited
        queue.add(new int[]{sr,sc});
        //modify special pixel to color
        image[sr][sc] = color;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.remove();
            int cr = curr[0], cc = curr[1];

            for (int k = 0; k < DIRS.length; k++) {
                int nr = cr+DIRS[k][0], nc = cc+DIRS[k][1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && image[nr][nc] == original) {
                    image[nr][nc] = color;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
        
        //now that image is done being modified, return image
        return image;
    }
}
