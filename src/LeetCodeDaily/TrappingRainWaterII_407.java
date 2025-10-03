package LeetCodeDaily;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TrappingRainWaterII_407 {

    public static int trappingRainWater(int[][] heights) {
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        int m = heights.length, n = heights[0].length;
        boolean[][] visited = new boolean[m][n];

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // filling left-most and right-most column
        for (int i = 0; i < m; i++) {
            minHeap.offer(new int[] { heights[i][0], i, 0 });
            minHeap.offer(new int[] { heights[i][n - 1], i, n - 1 });
            visited[i][0] = visited[i][n - 1] = true;
        }

        // filling top-most and bottom-most column
        for (int i = 0; i < n; i++) {
            minHeap.offer(new int[] { heights[0][i], 0, i });
            minHeap.offer(new int[] { heights[m - 1][i], m - 1, i });
            visited[0][i] = visited[m - 1][i] = true;
        }

        int water = 0;

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int currHeight = curr[0], r = curr[1], c = curr[2];

            for (int[] dir : dirs) {
                int row = dir[0] + r;
                int col = dir[1] + c;

                if (row >= 0 && row < m && col >= 0 && col < n && !visited[row][col]) {
                    int height = heights[row][col];
                    if (height < currHeight) {
                        water += currHeight - height;
                    }
                    int[] newBoundary = { Math.max(height, currHeight), row, col };
                    minHeap.offer(newBoundary);
                    visited[row][col] = true;
                }
            }
        }

        return water;
    }

    public static void main(String[] args) {
        int[][] heights1 = {{1,4,3,1,3,2}, {3,2,1,3,2,4}, {2,3,3,2,3,1}};
        int[][] heights2 = {{3,3,3,3,3}, {3,2,2,2,3}, {3,2,1,2,3},{3,2,2,2,3},{3,3,3,3,3}};
        System.out.println(trappingRainWater(heights1));
        System.out.println(trappingRainWater(heights2));
    }
}
