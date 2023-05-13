package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MultiGraph<T> implements IGraph<T> {



    private ArrayList<Node<T>> nodes;

    public MultiGraph() {

        nodes = new ArrayList<Node<T>>();


    }

    public void addNode(T value) {
        nodes.add(new Node<T>(value));
    }

    public boolean addEdge(T value1, T value2) {

        if(value1==value2) {

            return false;
        }

        Node<T> node1 = getNode(value1);
        Node<T> node2 = getNode(value2);
        node1.addEdge(node2);
        node2.addEdge(node1);

        return true;

    }



    public Node<T> getNode(T value) {
        for (Node<T> node : nodes) {
            if (node.getValue().equals(value)) {
                return node;
            }
        }
        return null;
    }




    public void printGraph() {
        for (Node<T> node : nodes) {
            System.out.print(node.getValue() + ": ");
            for (Node<T> edge : node.getEdges()) {
                System.out.print(edge.getValue() + " ");
            }
            System.out.println();
        }
    }




    public List<T> bfs(T startValue) {
        List<T> visitedValues = new ArrayList<>();
        Queue<Node<T>> queue = new LinkedList<>();
        Node<T> startNode = getNode(startValue);
        if (startNode != null) {
            visitedValues.add(startValue);
            queue.add(startNode);
            while (!queue.isEmpty()) {
                Node<T> currNode = queue.poll();
                for (Node<T> neighbor : currNode.getEdges()) {
                    if (!visitedValues.contains(neighbor.getValue())) {
                        visitedValues.add(neighbor.getValue());
                        queue.add(neighbor);
                    }
                }
            }
        }
        return visitedValues;
    }





    public List<T> dfs(T startValue) {
        List<T> visitedValues = new ArrayList<>();
        Node<T> startNode = getNode(startValue);
        if (startNode != null) {
            dfsHelper(startNode, visitedValues);
        }
        return visitedValues;
    }

    private void dfsHelper(Node<T> currNode, List<T> visitedValues) {
        visitedValues.add(currNode.getValue());
        for (Node<T> neighbor : currNode.getEdges()) {
            if (!visitedValues.contains(neighbor.getValue())) {
                dfsHelper(neighbor, visitedValues);
            }
        }
    }











}