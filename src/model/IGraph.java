package model;

import java.util.List;

public interface IGraph<T> {

    void addNode(T value);

    boolean addEdge(T value1, T value2);

    List<T> bfs(T startValue);

    List<T> dfs(T startValue);

    void printGraph();
}