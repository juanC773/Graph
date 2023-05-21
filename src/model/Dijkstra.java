package model;

import java.util.*;

public class Dijkstra<T> {
    private Map<T, Map<T, Integer>> adjacencyMap;

    public Dijkstra() {
        adjacencyMap = new HashMap<>();
    }

    public void addVertex(T vertex) {
        adjacencyMap.put(vertex, new HashMap<>());
    }

    public void addEdge(T source, T destination, int weight) {
        adjacencyMap.get(source).put(destination, weight);
        adjacencyMap.get(destination).put(source, weight);
    }

    public Map<T, Integer> dijkstra(T start) {
        Map<T, Integer> distances = new HashMap<>();
        for (T vertex : adjacencyMap.keySet()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        Set<T> visited = new HashSet<>();
        PriorityQueue<Node<T>> queue = new PriorityQueue<>();
        queue.add(new Node<>(start, 0));

        while (!queue.isEmpty()) {
            Node<T> currentNode = queue.poll();
            T currentVertex = currentNode.getVertex();
            int currentDistance = currentNode.getDistance();

            if (visited.contains(currentVertex)) {
                continue;
            }

            visited.add(currentVertex);

            Map<T, Integer> neighbors = adjacencyMap.get(currentVertex);
            for (T neighbor : neighbors.keySet()) {
                int weight = neighbors.get(neighbor);
                int newDistance = currentDistance + weight;

                if (newDistance < distances.get(neighbor)) {
                    distances.put(neighbor, newDistance);
                    queue.add(new Node<>(neighbor, newDistance));
                }
            }
        }

        return distances;
    }

    private static class Node<T> implements Comparable<Node<T>> {
        private T vertex;
        private int distance;

        public Node(T vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        public T getVertex() {
            return vertex;
        }

        public int getDistance() {
            return distance;
        }

        @Override
        public int compareTo(Node<T> other) {
            return Integer.compare(distance, other.distance);
        }
    }
}