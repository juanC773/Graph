package model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DirectedGraphTest {


    //Los metodos de bfs dfs ya estan testeados en Simplegraph ya que son los mismos metodos


    @Test
    public void testAddEdge() {

        boolean pass=false;
        DirectedGraph<Integer> graph=new DirectedGraph<>();
        graph.addNode(1);
        graph.addNode(2);

        graph.addEdge(1, 2);

        Node temp= graph.getNode(2);

        if (temp.getEdges().isEmpty()) {
            pass = true;
        }

        assertTrue(pass);
    }

    @Test
    public void testAddEdgeWithSelfLoop() {
        DirectedGraph<String> graph = new DirectedGraph<>();
        graph.addNode("A");
        boolean result = graph.addEdge("A", "A");
        assertTrue(result);
        assertEquals(1, graph.getNode("A").getEdges().size());
        assertEquals("A", graph.getNode("A").getEdges().get(0).getValue());
    }


    @Test
    public void testAddEdgeNoDuplicates() {
        DirectedGraph<Integer> graph = new DirectedGraph<>();
        graph.addNode(1);
        graph.addNode(2);
        assertTrue(graph.addEdge(1, 2));
        assertFalse(graph.addEdge(1, 2)); // should not create multiple edges between same nodes
    }

}
