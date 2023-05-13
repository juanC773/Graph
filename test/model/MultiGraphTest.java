package model;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MultiGraphTest {


    //Los metodos de bfs dfs ya estan testeados en Simplegraph ya que son los mismos metodos

    @Test
    public void testAddMultipleEdges() {
        MultiGraph<Integer> graph = new MultiGraph<>();
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 2); // Add multiple edges between 1 and 2
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);

        List<Integer> bfsResult = graph.bfs(1);
        List<Integer> dfsResult = graph.dfs(1);

        // Check that all nodes are visited in the correct order
        assertEquals(Arrays.asList(1, 2, 3), bfsResult);
        assertEquals(Arrays.asList(1, 2, 3), dfsResult);

        // Check that the graph contains the expected edges
        Node<Integer> node1 = graph.getNode(1);
        Node<Integer> node2 = graph.getNode(2);
          Node<Integer> node3 = graph.getNode(3);
        assertEquals(Arrays.asList(node2, node3), node1.getEdges());
        assertEquals(Arrays.asList(node1, node3), node2.getEdges());
        assertEquals(Arrays.asList(node1, node2), node3.getEdges());

    }



    @Test
    public void testAddEdgeNoLoop() {
        SimpleGraph<Integer> graph = new SimpleGraph<>();
        graph.addNode(1);
        graph.addNode(2);
        graph.addEdge(1, 2);
        assertFalse(graph.addEdge(1, 1)); // should not create a loop
    }


}
