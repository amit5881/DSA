package ByteByteGo.Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GraphDeepCopy {

    public static GraphNode graphDeepCopy(GraphNode node) {
        if (node == null) return null;

        Map<GraphNode, GraphNode> map = new HashMap<>();
        return dfs(node, map);
    }

    private static GraphNode dfs(GraphNode node, Map<GraphNode, GraphNode> map) {
        if (map.containsKey(node)) return map.get(node);

        GraphNode clonedNode = new GraphNode(node.data);
        map.put(node, clonedNode);

        for (GraphNode neighbour : node.neighbours) {
            GraphNode clonedNeighbour = dfs(neighbour, map);
            clonedNode.neighbours.add(clonedNeighbour);
        }
        return clonedNode;
    }

    public static void main(String[] args) {
        GraphNode root = new GraphNode(0);
        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);

        root.neighbours.add(node1);
        root.neighbours.add(node2);

        node1.neighbours.add(node2);
        node1.neighbours.add(root);

        node2.neighbours.add(root);
        node2.neighbours.add(node1);
        node2.neighbours.add(node3);

        node3.neighbours.add(node2);

        printGraph(root, new HashSet<>());

        root = graphDeepCopy(root);
        System.out.println();

        printGraph(root, new HashSet<>());
    }

    // DFS-based print to avoid infinite loops in cyclic graphs
    private static void printGraph(GraphNode node, Set<GraphNode> visited) {
        if (node == null || visited.contains(node)) return;

        visited.add(node);
        System.out.print("Node " + node.data + " -> ");
        for (GraphNode neighbour : node.neighbours) {
            System.out.print(neighbour.data + " ");
        }

        System.out.println();
        for (GraphNode neighbour : node.neighbours) {
            printGraph(neighbour, visited);
        }
    }
}
