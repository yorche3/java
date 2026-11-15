package data_structures_advanced;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class DataStructuresAdvancedTest {

    private static final int PARENT_INPUT = 10;
    private static final int LEFT_INPUT = 20;
    private static final int RIGHT_INPUT = 30;

    private static final int ROOT_INPUT = 50;
    private static final int LOWER_INPUT = 30;
    private static final int HIGHER_INPUT = 70;
    private static final int LOWER_LEAF_INPUT = 20;
    private static final int MIDDLE_LEAF_INPUT = 40;
    private static final int MISSING_TREE_INPUT = 99;
    private static final int EMPTY_TREE_SIZE_OUTPUT = 0;

    private static final int VERTEX_A = 10;
    private static final int VERTEX_B = 30;
    private static final int VERTEX_C = 50;
    private static final int VERTEX_D = 70;
    private static final int MISSING_VERTEX = 99;
    private static final int SECOND_MISSING_VERTEX = 98;

    private static void assertTreeContains(BinaryTree tree, String subject, int... values) {
        for (int value : values) {
            assertTrue(tree.contains(value), subject + " should contain " + value);
        }
    }

    private static void assertGraphCounts(Graph graph, int vertices, int edges, String subject) {
        assertEquals(vertices, graph.vertexCount(), subject + " should report vertex count " + vertices);
        assertEquals(edges, graph.edgeCount(), subject + " should report edge count " + edges);
    }

    // TreeNode

    @Test
    void treeNodeCreateStoresValue() {
        TreeNode node = new TreeNode(PARENT_INPUT);
        assertEquals(PARENT_INPUT, node.getValue(), "TreeNode create should preserve the value");
    }

    @Test
    void treeNodeInitialLinksAbsent() {
        TreeNode node = new TreeNode(PARENT_INPUT);
        assertNull(node.getLeft(), "TreeNode initial left link should be absent");
        assertNull(node.getRight(), "TreeNode initial right link should be absent");
    }

    @Test
    void treeNodeLinkTwoChildren() {
        TreeNode parent = new TreeNode(PARENT_INPUT);
        parent.setLeft(new TreeNode(LEFT_INPUT));
        parent.setRight(new TreeNode(RIGHT_INPUT));
        assertNotNull(parent.getLeft(), "TreeNode link two children should expose the left child");
        assertNotNull(parent.getRight(), "TreeNode link two children should expose the right child");
        assertEquals(LEFT_INPUT, parent.getLeft().getValue(),
                "TreeNode link two children should lead left to 20");
        assertEquals(RIGHT_INPUT, parent.getRight().getValue(),
                "TreeNode link two children should lead right to 30");
    }

    @Test
    void treeNodeTraverseEachLink() {
        TreeNode parent = new TreeNode(PARENT_INPUT);
        parent.setLeft(new TreeNode(LEFT_INPUT));
        parent.setRight(new TreeNode(RIGHT_INPUT));
        TreeNode left = parent.getLeft();
        TreeNode right = parent.getRight();
        assertNotNull(left, "TreeNode traverse should reach the left child");
        assertNotNull(right, "TreeNode traverse should reach the right child");
        assertEquals(LEFT_INPUT, left.getValue(), "TreeNode traverse should reach value 20 on the left");
        assertEquals(RIGHT_INPUT, right.getValue(), "TreeNode traverse should reach value 30 on the right");
        assertNull(left.getLeft(), "TreeNode left child left link should be absent");
        assertNull(left.getRight(), "TreeNode left child right link should be absent");
        assertNull(right.getLeft(), "TreeNode right child left link should be absent");
        assertNull(right.getRight(), "TreeNode right child right link should be absent");
    }

    @Test
    void treeNodeUnlinkChildren() {
        TreeNode parent = new TreeNode(PARENT_INPUT);
        parent.setLeft(new TreeNode(LEFT_INPUT));
        parent.setRight(new TreeNode(RIGHT_INPUT));

        parent.setLeft(null);
        assertNull(parent.getLeft(), "TreeNode unlink should clear the left link");
        assertEquals(PARENT_INPUT, parent.getValue(), "TreeNode unlink left should preserve value 10");
        assertNotNull(parent.getRight(), "TreeNode unlink left should preserve the right child");
        assertEquals(RIGHT_INPUT, parent.getRight().getValue(),
                "TreeNode unlink left should preserve right child 30");

        parent.setRight(null);
        assertNull(parent.getLeft(), "TreeNode unlink both should leave the left link absent");
        assertNull(parent.getRight(), "TreeNode unlink both should leave the right link absent");
        assertEquals(PARENT_INPUT, parent.getValue(), "TreeNode unlink both should preserve value 10");
    }

    // BinaryTree

    @Test
    void binaryTreeCreateEmpty() {
        BinaryTree tree = new BinaryTree();
        assertTrue(tree.isEmpty(), "BinaryTree create empty should be empty");
        assertEquals(EMPTY_TREE_SIZE_OUTPUT, tree.size(), "BinaryTree create empty should have size 0");
        assertFalse(tree.contains(ROOT_INPUT), "BinaryTree create empty should not contain 50");
    }

    @Test
    void binaryTreeInsertRoot() {
        BinaryTree tree = new BinaryTree();
        assertTrue(tree.insert(ROOT_INPUT), "BinaryTree insert root should succeed");
        assertEquals(1, tree.size(), "BinaryTree insert root should have size 1");
        assertFalse(tree.isEmpty(), "BinaryTree insert root should not be empty");
        assertTrue(tree.contains(ROOT_INPUT), "BinaryTree insert root should contain 50");
    }

    @Test
    void binaryTreeInsertLowerAndHigher() {
        BinaryTree tree = new BinaryTree();
        assertTrue(tree.insert(ROOT_INPUT), "BinaryTree insert 50 should succeed");
        assertTrue(tree.insert(LOWER_INPUT), "BinaryTree insert 30 should succeed");
        assertTrue(tree.insert(HIGHER_INPUT), "BinaryTree insert 70 should succeed");
        assertEquals(3, tree.size(), "BinaryTree lower and higher should have size 3");
        assertTreeContains(tree, "BinaryTree lower and higher", ROOT_INPUT, LOWER_INPUT, HIGHER_INPUT);
    }

    @Test
    void binaryTreeMultilevelBranches() {
        BinaryTree tree = new BinaryTree();
        int[] inputs = {ROOT_INPUT, LOWER_INPUT, HIGHER_INPUT, LOWER_LEAF_INPUT, MIDDLE_LEAF_INPUT};
        for (int input : inputs) {
            assertTrue(tree.insert(input), "BinaryTree multilevel insert " + input + " should succeed");
        }
        assertTreeContains(tree, "BinaryTree multilevel", inputs);
        assertEquals(5, tree.size(), "BinaryTree multilevel should have size 5");
    }

    @Test
    void binaryTreeMissingValueInNonEmptyTree() {
        BinaryTree tree = new BinaryTree();
        tree.insert(ROOT_INPUT);
        assertFalse(tree.contains(MISSING_TREE_INPUT), "BinaryTree missing value should not contain 99");
        assertEquals(1, tree.size(), "BinaryTree missing value query should keep size 1");
        assertTrue(tree.contains(ROOT_INPUT), "BinaryTree missing value query should keep 50");
    }

    @Test
    void binaryTreeIdempotentDuplicate() {
        BinaryTree tree = new BinaryTree();
        int[] inputs = {ROOT_INPUT, LOWER_INPUT, HIGHER_INPUT, LOWER_INPUT};
        for (int input : inputs) {
            assertTrue(tree.insert(input), "BinaryTree duplicate scenario insert " + input + " should succeed");
        }
        assertEquals(3, tree.size(), "BinaryTree duplicate should keep size 3");
        assertTreeContains(tree, "BinaryTree duplicate", ROOT_INPUT, LOWER_INPUT, HIGHER_INPUT);
    }

    @Test
    void binaryTreeOrderedInsertions() {
        BinaryTree tree = new BinaryTree();
        int[] inputs = {LOWER_LEAF_INPUT, LOWER_INPUT, MIDDLE_LEAF_INPUT, ROOT_INPUT, HIGHER_INPUT};
        for (int input : inputs) {
            assertTrue(tree.insert(input), "BinaryTree ordered insert " + input + " should succeed");
        }
        assertEquals(5, tree.size(), "BinaryTree ordered insertions should have size 5");
        assertTreeContains(tree, "BinaryTree ordered insertions", inputs);
        assertFalse(tree.contains(MISSING_TREE_INPUT), "BinaryTree ordered insertions should not contain 99");
    }

    // Graph

    @Test
    void graphCreateEmpty() {
        Graph graph = new Graph();
        assertTrue(graph.isEmpty(), "Graph create empty should be empty");
        assertGraphCounts(graph, 0, 0, "Graph create empty");
        assertFalse(graph.hasEdge(VERTEX_A, VERTEX_B), "Graph create empty should not have edge 10->30");
        assertNull(graph.getNeighbors(VERTEX_A), "Graph create empty should fail neighbours of 10");
    }

    @Test
    void graphIsolatedVertex() {
        Graph graph = new Graph();
        assertTrue(graph.addVertex(VERTEX_A), "Graph isolated vertex add should succeed");
        assertFalse(graph.isEmpty(), "Graph isolated vertex should not be empty");
        assertGraphCounts(graph, 1, 0, "Graph isolated vertex");
        assertEquals(List.of(), graph.getNeighbors(VERTEX_A), "Graph isolated vertex should have empty neighbours");
    }

    @Test
    void graphNonconsecutiveLabelsAndDirectedEdge() {
        Graph graph = new Graph();
        assertTrue(graph.addVertex(VERTEX_A), "Graph directed edge add 10 should succeed");
        assertTrue(graph.addVertex(VERTEX_D), "Graph directed edge add 70 should succeed");
        assertTrue(graph.addEdge(VERTEX_A, VERTEX_D), "Graph directed edge 10->70 should succeed");
        assertTrue(graph.hasEdge(VERTEX_A, VERTEX_D), "Graph directed edge should have 10->70");
        assertFalse(graph.hasEdge(VERTEX_D, VERTEX_A), "Graph directed edge should not have 70->10");
        assertGraphCounts(graph, 2, 1, "Graph directed edge");
    }

    @Test
    void graphDuplicateVertexPreservesAdjacency() {
        Graph graph = new Graph();
        assertTrue(graph.addVertex(VERTEX_A), "Graph duplicate vertex add 10 should succeed");
        assertTrue(graph.addVertex(VERTEX_B), "Graph duplicate vertex add 30 should succeed");
        assertTrue(graph.addEdge(VERTEX_A, VERTEX_B), "Graph duplicate vertex edge 10->30 should succeed");
        assertTrue(graph.addVertex(VERTEX_A), "Graph duplicate vertex re-add 10 should succeed");
        assertGraphCounts(graph, 2, 1, "Graph duplicate vertex");
        assertEquals(List.of(VERTEX_B), graph.getNeighbors(VERTEX_A),
                "Graph duplicate vertex should keep neighbours of 10 as [30]");
    }

    @Test
    void graphDuplicateEdge() {
        Graph graph = new Graph();
        graph.addVertex(VERTEX_A);
        graph.addVertex(VERTEX_B);
        assertTrue(graph.addEdge(VERTEX_A, VERTEX_B), "Graph duplicate edge first add should succeed");
        assertTrue(graph.addEdge(VERTEX_A, VERTEX_B), "Graph duplicate edge second add should succeed");
        assertGraphCounts(graph, 2, 1, "Graph duplicate edge");
        assertEquals(List.of(VERTEX_B), graph.getNeighbors(VERTEX_A),
                "Graph duplicate edge should keep neighbours of 10 as [30]");
    }

    @Test
    void graphMissingEndpointWithoutMutation() {
        Graph graph = new Graph();
        graph.addVertex(VERTEX_A);
        graph.addVertex(VERTEX_B);
        assertTrue(graph.addEdge(VERTEX_A, VERTEX_B), "Graph missing endpoint setup edge should succeed");
        assertFalse(graph.addEdge(VERTEX_A, MISSING_VERTEX), "Graph edge 10->99 should fail");
        assertFalse(graph.addEdge(MISSING_VERTEX, VERTEX_A), "Graph edge 99->10 should fail");
        assertFalse(graph.addEdge(SECOND_MISSING_VERTEX, MISSING_VERTEX), "Graph edge 98->99 should fail");
        assertFalse(graph.addEdge(MISSING_VERTEX, MISSING_VERTEX), "Graph edge 99->99 should fail");
        assertGraphCounts(graph, 2, 1, "Graph missing endpoint");
        assertEquals(List.of(VERTEX_B), graph.getNeighbors(VERTEX_A),
                "Graph missing endpoint should preserve neighbours of 10");
        assertEquals(List.of(), graph.getNeighbors(VERTEX_B),
                "Graph missing endpoint should keep neighbours of 30 empty");
        assertFalse(graph.hasEdge(VERTEX_A, MISSING_VERTEX), "Graph missing endpoint should not have 10->99");
        assertFalse(graph.hasEdge(MISSING_VERTEX, VERTEX_A), "Graph missing endpoint should not have 99->10");
        assertFalse(graph.hasEdge(SECOND_MISSING_VERTEX, MISSING_VERTEX),
                "Graph missing endpoint should not have 98->99");
        assertFalse(graph.hasEdge(MISSING_VERTEX, MISSING_VERTEX), "Graph missing endpoint should not have 99->99");
        assertNull(graph.getNeighbors(SECOND_MISSING_VERTEX), "Graph missing vertex 98 should fail neighbours");
        assertNull(graph.getNeighbors(MISSING_VERTEX), "Graph missing vertex 99 should fail neighbours");
    }

    @Test
    void graphSortedNeighboursAndCounts() {
        Graph graph = new Graph();
        for (int label : new int[] {VERTEX_A, VERTEX_B, VERTEX_C, VERTEX_D}) {
            assertTrue(graph.addVertex(label), "Graph sorted neighbours add vertex " + label + " should succeed");
        }
        assertTrue(graph.addEdge(VERTEX_A, VERTEX_D), "Graph sorted neighbours edge 10->70 should succeed");
        assertTrue(graph.addEdge(VERTEX_A, VERTEX_B), "Graph sorted neighbours edge 10->30 should succeed");
        assertTrue(graph.addEdge(VERTEX_A, VERTEX_C), "Graph sorted neighbours edge 10->50 should succeed");
        assertTrue(graph.addEdge(VERTEX_B, VERTEX_C), "Graph sorted neighbours edge 30->50 should succeed");
        assertEquals(List.of(VERTEX_B, VERTEX_C, VERTEX_D), graph.getNeighbors(VERTEX_A),
                "Graph sorted neighbours of 10 should be [30, 50, 70]");
        assertEquals(List.of(VERTEX_C), graph.getNeighbors(VERTEX_B),
                "Graph sorted neighbours of 30 should be [50]");
        assertEquals(List.of(), graph.getNeighbors(VERTEX_C), "Graph sorted neighbours of 50 should be empty");
        assertEquals(List.of(), graph.getNeighbors(VERTEX_D), "Graph sorted neighbours of 70 should be empty");
        assertGraphCounts(graph, 4, 4, "Graph sorted neighbours");
    }

    @Test
    void graphMissingEdgeQuery() {
        Graph graph = new Graph();
        graph.addVertex(VERTEX_A);
        graph.addVertex(VERTEX_B);
        assertFalse(graph.hasEdge(VERTEX_A, VERTEX_B), "Graph missing-edge query should fail for 10->30");
        assertGraphCounts(graph, 2, 0, "Graph missing-edge query");
        assertFalse(graph.isEmpty(), "Graph missing-edge query should not be empty");
    }

    @Test
    void graphNeighboursOfMissingVertex() {
        Graph graph = new Graph();
        graph.addVertex(VERTEX_A);
        assertNull(graph.getNeighbors(MISSING_VERTEX), "Graph neighbours of 99 should signal failure");
        assertNotNull(graph.getNeighbors(VERTEX_A), "Graph neighbours of 10 should differ from failure");
        assertEquals(List.of(), graph.getNeighbors(VERTEX_A), "Graph neighbours of 10 should be empty");
        assertGraphCounts(graph, 1, 0, "Graph neighbours of missing vertex");
    }

    @Test
    void graphSelfLoopAndDuplicate() {
        Graph graph = new Graph();
        graph.addVertex(VERTEX_A);
        assertTrue(graph.addEdge(VERTEX_A, VERTEX_A), "Graph self-loop first add should succeed");
        assertTrue(graph.addEdge(VERTEX_A, VERTEX_A), "Graph self-loop second add should succeed");
        assertTrue(graph.hasEdge(VERTEX_A, VERTEX_A), "Graph self-loop should be present");
        assertEquals(List.of(VERTEX_A), graph.getNeighbors(VERTEX_A), "Graph self-loop neighbours should be [10]");
        assertGraphCounts(graph, 1, 1, "Graph self-loop");
    }

    @Test
    void graphNeighbourResultIsolation() {
        Graph graph = new Graph();
        graph.addVertex(VERTEX_A);
        graph.addVertex(VERTEX_B);
        graph.addVertex(VERTEX_C);
        assertTrue(graph.addEdge(VERTEX_A, VERTEX_B), "Graph isolation edge 10->30 should succeed");
        List<Integer> saved = graph.getNeighbors(VERTEX_A);
        assertNotNull(saved, "Graph isolation should return neighbours of 10");

        List<Integer> copy = graph.getNeighbors(VERTEX_A);
        assertNotNull(copy, "Graph isolation should return a second neighbour result");
        try {
            copy.add(MISSING_VERTEX);
            copy.remove(Integer.valueOf(VERTEX_B));
        } catch (UnsupportedOperationException immutableResult) {
            // Immutable result: the mutation step is not representable.
        }
        assertEquals(List.of(VERTEX_B), graph.getNeighbors(VERTEX_A),
                "Graph isolation should not change the graph when a copy changes");

        assertTrue(graph.addEdge(VERTEX_A, VERTEX_C), "Graph isolation edge 10->50 should succeed");
        assertEquals(List.of(VERTEX_B), new ArrayList<>(saved),
                "Graph isolation should keep the saved result as [30]");
        assertEquals(List.of(VERTEX_B, VERTEX_C), graph.getNeighbors(VERTEX_A),
                "Graph isolation fresh query should be [30, 50]");
        assertGraphCounts(graph, 3, 2, "Graph isolation");
    }
}
