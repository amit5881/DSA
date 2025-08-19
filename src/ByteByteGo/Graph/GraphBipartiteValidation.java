package ByteByteGo.Graph;

import java.util.Arrays;

public class GraphBipartiteValidation {

    public static boolean graphBipartiteValidation(int[][] graph) {
        int[] colours = new int[graph.length];
        Arrays.fill(colours, 0);

        for (int i = 0; i < graph.length; i++) {
            if (colours[i] == 0 && !dfs(i, 1, graph, colours)) return false;
        }
        return true;
    }

    private static boolean dfs(int node, int color, int[][] graph, int[] colours) {
        colours[node] = color;

        for (int neighbour : graph[node]) {
            if (colours[neighbour] == color) return false;

            if (colours[neighbour] == 0 && !dfs(neighbour, -color, graph, colours)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph1 = new int[][] {
                new int[]{1, 4},
                new int[]{0, 2},
                new int[]{1},
                new int[]{4},
                new int[]{0, 3}
        };

        int[][] graph2 = new int[][] {
                new int[]{1, 4},
                new int[]{0, 2},
                new int[]{3, 1},
                new int[]{2, 4},
                new int[]{0, 3}
        };

        System.out.println(graphBipartiteValidation(graph1));
        System.out.println(graphBipartiteValidation(graph2));
    }
}
