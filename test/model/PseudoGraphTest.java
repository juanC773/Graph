package model;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class PseudoGraphTest {


    //Los metodos de bfs dfs ya estan testeados en Simplegraph ya que son los mismos metodos




    @Test
    public void testAddEdgeWithSelfLoop() {
        PseudoGraph<String> graph = new PseudoGraph<>();
        graph.addNode("A");
        boolean result = graph.addEdge("A", "A");
        assertTrue(result);
        assertEquals(1, graph.getNode("A").getEdges().size());
        assertEquals("A", graph.getNode("A").getEdges().get(0).getValue());
    }

    @Test
    public void testAddMultipleEdges() {
        boolean pass=false;
        PseudoGraph<String> graph = new PseudoGraph<>();

        graph.addNode("A");
        graph.addNode("B");

        graph.addEdge("A","B");
        graph.addEdge("A","B");

        Node node= graph.getNode("A");
        ArrayList nodesTemp=node.getEdges();

        if(nodesTemp.size()==2){
            pass=true;
        }

        assertTrue(pass);



    }


}
