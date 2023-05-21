package  model;
public class Edge<T> {
    private Node<T> node;
    private double weight;

    public Edge(Node<T> node, double weight) {
        this.node = node;
        this.weight = weight;
    }

    public Node<T> getNode() {
        return node;
    }

    public double getWeight() {
        return weight;
    }
}