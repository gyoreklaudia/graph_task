package org.example;

import org.junit.Test;

import java.util.Collections;

import static junit.framework.TestCase.assertFalse;
import static org.example.Graph.isThereAWayWithAtLeastNNodes;
import static org.junit.Assert.assertTrue;


public class GraphTest {

    @Test
    public void testIsThereAWayWithAtLeastNNodes() {
        Graph graph = createGraph();
        assertTrue(isThereAWayWithAtLeastNNodes(graph, "Bob", 2, 1, Collections.<String>emptyList()));
        assertTrue(isThereAWayWithAtLeastNNodes(graph, "Bob", 3, 1, Collections.<String>emptyList()));
        assertTrue(isThereAWayWithAtLeastNNodes(graph, "Bob", 4, 1, Collections.<String>emptyList()));
        assertTrue(isThereAWayWithAtLeastNNodes(graph, "Maria", 4, 1, Collections.<String>emptyList()));

        assertFalse(isThereAWayWithAtLeastNNodes(graph, "Maria", 5, 1, Collections.<String>emptyList()));
        assertFalse(isThereAWayWithAtLeastNNodes(graph, "Maria", 9, 1, Collections.<String>emptyList()));
        assertFalse(isThereAWayWithAtLeastNNodes(graph, "Maria", 44, 1, Collections.<String>emptyList()));
    }

    /**
     * Create a simple graph to test the isThereAWayWithAtLeastNNodes method.
     * @return the graph
     */
    Graph createGraph() {
        Graph graph = new Graph();
        graph.addNode("Bob");
        graph.addNode("Alice");
        graph.addNode("Mark");
        graph.addNode("Rob");
        graph.addNode("Maria");
        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");
        return graph;
    }
}
