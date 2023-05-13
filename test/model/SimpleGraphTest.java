package model;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleGraphTest {

    @Test
    public void testBfs() {

        SimpleGraph<String> graph = new SimpleGraph<>();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");
        graph.addNode("F");
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "E");
        graph.addEdge("D", "E");
        graph.addEdge("D", "F");
        graph.addEdge("E", "F");

        List<String> result = graph.bfs("A");
        List<String> expected = Arrays.asList("A", "B", "C", "D", "E", "F");
        assertEquals(expected, result);

    }

    @Test
    public void testDfs() {
        SimpleGraph<String> graph = new SimpleGraph<>();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");
        graph.addNode("F");
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "E");
        graph.addEdge("D", "E");
        graph.addEdge("D", "F");
        graph.addEdge("E", "F");

        List<String> result = graph.dfs("A");
        List<String> expected = Arrays.asList("A", "B", "D", "E", "C", "F");
        assertEquals(expected, result);
    }




    @Test
    void testAddNode() {
        SimpleGraph<String> graph = new SimpleGraph<>();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        assertTrue(graph.bfs("A").contains("A"));
        assertTrue(graph.bfs("B").contains("B"));
        assertTrue(graph.bfs("C").contains("C"));
    }



    @Test
    void testAddEdge() {
        SimpleGraph<String> graph = new SimpleGraph<>();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        assertTrue(graph.addEdge("A", "B"));
        assertTrue(graph.addEdge("B", "C"));
        assertTrue(graph.addEdge("A", "C"));
        assertFalse(graph.addEdge("B", "A"));
        assertFalse(graph.addEdge("A", "B"));
        assertFalse(graph.addEdge("A", "A"));
        assertFalse(graph.addEdge("B", "B"));
        assertFalse(graph.addEdge("C", "C"));
        assertTrue(graph.bfs("A").contains("B"));
        assertTrue(graph.bfs("A").contains("C"));
        assertTrue(graph.bfs("B").contains("A"));
        assertTrue(graph.bfs("B").contains("C"));
        assertTrue(graph.bfs("C").contains("A"));
        assertTrue(graph.bfs("C").contains("B"));
    }



    @Test
    public void testAddEdgeNoLoop() {
        SimpleGraph<Integer> graph = new SimpleGraph<>();
        graph.addNode(1);
        graph.addNode(2);
        graph.addEdge(1, 2);
        assertFalse(graph.addEdge(1, 1)); // should not create a loop
    }

    @Test
    public void testAddEdgeNoDuplicates() {
        SimpleGraph<Integer> graph = new SimpleGraph<>();
        graph.addNode(1);
        graph.addNode(2);
        assertTrue(graph.addEdge(1, 2));
        assertFalse(graph.addEdge(1, 2)); // should not create multiple edges between same nodes
    }



}
