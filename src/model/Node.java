package model;

import java.util.ArrayList;

public class Node<T> {
    private T value;
    private ArrayList<Node<T>> edges;

    public Node(T value) {
        this.value = value;
        this.edges = new ArrayList<Node<T>>();
    }

    public void addEdge(Node<T> node) {
        edges.add(node);
    }

    public T getValue() {
        return value;
    }

    public ArrayList<Node<T>> getEdges() {
        return edges;
    }
}