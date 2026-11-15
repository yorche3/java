package data_structures_advanced;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private GraphNode vertices;
    private int vertexCount;
    private int edgeCount;

    public Graph() {
        this.vertices = null;
        this.vertexCount = 0;
        this.edgeCount = 0;
    }

    private GraphNode findVertex(int label) {
        GraphNode current = this.vertices;
        while (current != null) {
            if (current.getValue() == label) {
                return current;
            }
            current = current.nextVertex;
        }
        return null;
    }

    // Sorted insertion without duplicates.
    private void insertNeighbor(List<Integer> neighbors, int label) {
        int index = 0;
        while (index < neighbors.size() && neighbors.get(index) < label) {
            index++;
        }
        neighbors.add(index, label);
    }

    public boolean addVertex(int label) {
        if (findVertex(label) != null) {
            return true;
        }
        GraphNode newVertex = new GraphNode(label);
        newVertex.nextVertex = this.vertices;
        this.vertices = newVertex;
        this.vertexCount++;
        return true;
    }

    public boolean addEdge(int u, int v) {
        GraphNode vertexU = findVertex(u);
        if (vertexU == null || findVertex(v) == null) {
            return false;
        }
        if (vertexU.neighbors.contains(v)) {
            return true;
        }
        insertNeighbor(vertexU.neighbors, v);
        this.edgeCount++;
        return true;
    }

    public boolean hasEdge(int u, int v) {
        GraphNode vertexU = findVertex(u);
        return vertexU != null && vertexU.neighbors.contains(v);
    }

    public List<Integer> getNeighbors(int u) {
        GraphNode vertexU = findVertex(u);
        if (vertexU == null) {
            return null;
        }
        return new ArrayList<>(vertexU.neighbors);
    }

    public boolean isEmpty() {
        return this.vertexCount == 0;
    }

    public int vertexCount() {
        return this.vertexCount;
    }

    public int edgeCount() {
        return this.edgeCount;
    }
}
