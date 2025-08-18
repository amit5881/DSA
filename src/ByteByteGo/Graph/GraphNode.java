package ByteByteGo.Graph;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    int data;
    List<GraphNode> neighbours;

    public GraphNode(GraphNode node) {
        this.data = node.data;
        this.neighbours = node.neighbours;
    }

    public GraphNode(int data) {
        this.data = data;
        this.neighbours = new ArrayList<>();
    }
}
