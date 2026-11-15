package data_structures_advanced;

import java.util.List;
import java.util.ArrayList;

class GraphNode extends Node {

    final List<Integer> neighbors = new ArrayList<>();
    GraphNode nextVertex;

    GraphNode(int label) {
        super(label);
        this.nextVertex = null;
    }
}
