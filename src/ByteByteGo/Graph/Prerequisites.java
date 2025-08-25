package ByteByteGo.Graph;

import java.util.*;

public class Prerequisites {

    private static boolean prerequisites(int n, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[n];
        Arrays.fill(inDegree, 0);

        for (int[] p : prerequisites) {
            int prerequisite = p[0];
            int course = p[1];
            graph.computeIfAbsent(prerequisite, k -> new ArrayList<>()).add(course);
            inDegree[prerequisite]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int enrolledCourses = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            enrolledCourses++;

            for (int neighbour : graph.get(node)) {
                inDegree[neighbour]--;

                if (inDegree[neighbour] == 0) queue.offer(neighbour);
            }
        }
        return enrolledCourses == n;
    }

    public static void main(String[] args) {
        boolean result = prerequisites(3, new int[][] {
                new int[]{0, 1},
                new int[]{1, 2},
                new int[]{2, 1}
        });
        System.out.println(result);
    }

}
