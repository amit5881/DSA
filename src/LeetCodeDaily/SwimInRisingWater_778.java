package LeetCodeDaily;

import java.util.PriorityQueue;

public class SwimInRisingWater_778 {

    static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static int swimWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        visited[0][0] = true;
        minHeap.offer(new int[]{ 0, 0, grid[0][0] });

        while (!minHeap.isEmpty()) {
            int[] cell = minHeap.poll();

            for (int[] dir : dirs) {
                int x = cell[0] + dir[0];
                int y = cell[1] + dir[1];
                int h = cell[2];

                if (x < 0 || x >= n || y < 0 || y >= n || visited[x][y]) continue;

                visited[x][y] = true;
                int height = grid[x][y];
                h = Math.max(h, height);

                if (x == n - 1 && y == n - 1) return h;

                minHeap.offer(new int[] {x, y, h});
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1,2,3,4}, {24,23,22,21,5}, {12,13,14,15,16}, {11,17,18,19,20}, {10,9,8,7,6}};
        System.out.println(swimWater(grid));
    }
}
