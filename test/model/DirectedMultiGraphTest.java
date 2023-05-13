package model;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DirectedMultiGraphTest {

    //Los metodos de bfs dfs ya estan testeados en Simplegraph ya que son los mismos metodos



    @Test
    public void testAddEdge() {

        boolean pass=false;
        DirectedMultiGraph<Integer> graph=new DirectedMultiGraph<>();
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
    public void testAddMultipleEdges() {
        boolean pass=false;
        DirectedMultiGraph<String> graph = new DirectedMultiGraph<>();

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




    @Test
    public void testAddEdgeWithSelfLoop() {
        DirectedMultiGraph<String> graph = new DirectedMultiGraph<>();
        graph.addNode("A");
        boolean result = graph.addEdge("A", "A");
        assertTrue(result);
        assertEquals(1, graph.getNode("A").getEdges().size());
        assertEquals("A", graph.getNode("A").getEdges().get(0).getValue());
    }



}



