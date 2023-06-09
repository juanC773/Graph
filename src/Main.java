import model.*;
import model.SimpleGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);

        while (true) {
            System.out.println(
                    """ 
                            \nSelect one type of graph:
                            ------------------------
                             1. Simple  
                             2. Directer
                             3. Multigraph
                             4. PseudoGraph
                             5. Directed Multigraph
                             6. Dijkstra
                             7. Exit:C
                            """
            );
            //simple: aristas no dirigidas, aristass multiples: no, bucles: no
            int option = lector.nextInt();
            lector.nextLine();

            switch (option) {

                case 1:
                    simpleGraph();
                    break;

                case 2:
                    managedGraph();
                    break;

                case 3:
                    multigraph();
                    break;

                case 4:
                    pseudoGraph();
                    break;

                case 5:
                    directedMultiGraph();

                    break;

                case 6:
                    dijkstra();
                    break;

                case 7:
                    System.exit(0);
                    break;


            }



        }
    }


    public static void simpleGraph() {

        SimpleGraph simpleGraph = new SimpleGraph<>();

        simpleGraph.addNode("A");
        simpleGraph.addNode("B");

        simpleGraph.addEdge("A", "A");
        simpleGraph.addEdge("A", "B");
        simpleGraph.addEdge("A", "B");
        simpleGraph.addNode("C");
        simpleGraph.addEdge("A","C");
        simpleGraph.addNode("D");


        List visited = simpleGraph.bfs("A");


        for (int i = 0; i < visited.size(); i++) {

            System.out.println(visited.get(i));
        }


        List visitedDFS=simpleGraph.dfs("D");




        for (int i = 0; i < visitedDFS.size(); i++) {

            System.out.println(visitedDFS.get(i));
        }

    }

    public static void managedGraph(){

        DirectedGraph directedGraph=new DirectedGraph<>();
        directedGraph.addNode("A");
        directedGraph.addNode("B");

        directedGraph.addEdge("A","B");
        directedGraph.addEdge("A","B");
        directedGraph.addEdge("A","A");
        directedGraph.addEdge("A","A");

        directedGraph.printGraph();


    }


    public static void multigraph(){

        MultiGraph multiGraph=new MultiGraph<>();

        multiGraph.addNode("A");
        multiGraph.addNode("B");

        multiGraph.addEdge("A","B");
        multiGraph.addEdge("A","B");
        multiGraph.addEdge("A","A");
        multiGraph.printGraph();

    }


    public static void pseudoGraph(){
        PseudoGraph pseudoGraph=new PseudoGraph<>();

        pseudoGraph.addNode("A");
        pseudoGraph.addNode("B");

        pseudoGraph.addEdge("A","B");
        pseudoGraph.addEdge("A","B");
        pseudoGraph.addEdge("A","A");
        pseudoGraph.printGraph();
    }


    public static void directedMultiGraph(){

        DirectedMultiGraph directedMultiGraph=new DirectedMultiGraph<>();

       directedMultiGraph.addNode("A");
        directedMultiGraph.addNode("B");

        directedMultiGraph.addEdge("A","B");
        directedMultiGraph.addEdge("A","B");
        directedMultiGraph.addEdge("A","A");
        directedMultiGraph.addEdge("A","A");
        directedMultiGraph.printGraph();

    }


    public static void dijkstra(){

        Dijkstra<String> dijkstra = new Dijkstra<>();

        // Agregar vértices
        dijkstra.addVertex("A");
        dijkstra.addVertex("B");
        dijkstra.addVertex("C");
        dijkstra.addVertex("D");
        dijkstra.addVertex("E");

        // Agregar aristas
        dijkstra.addEdge("A", "B", 2);
        dijkstra.addEdge("A", "C", 4);
        dijkstra.addEdge("B", "C", 1);
        dijkstra.addEdge("B", "D", 7);
        dijkstra.addEdge("C", "D", 3);
        dijkstra.addEdge("C", "E", 5);
        dijkstra.addEdge("D", "E", 2);

        // Ejecutar algoritmo de Dijkstra
        Map<String, Integer> distances = dijkstra.dijkstra("A");

        // Imprimir las distancias más cortas desde el vértice "A"
        for (Map.Entry<String, Integer> entry : distances.entrySet()) {
            String vertex = entry.getKey();
            int distance = entry.getValue();
            System.out.println("Distancia más corta desde A hasta " + vertex + ": " + distance);
        }

    }

}