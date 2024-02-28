package org.example.datastructures.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MatrixGraphs {


}

class AdjacencyMatrixGraph {

    private int _numberOfVertices;

    private int _numberOfEdges;

    private int[][] _adjacency;

    static final int EDGE_EXIST = 1;
    static final int EDGE_NONE = 0;

    public AdjacencyMatrixGraph(int givenNumberOfVertices) {
        this.setNumberOfVertices(givenNumberOfVertices);
        this.setNumberOfEdges(0);
        this.setAdjacency(new int[givenNumberOfVertices][givenNumberOfVertices]);
        for (int i = 0; i < givenNumberOfVertices; i++) {
            for (int j = 0; j < givenNumberOfVertices; j++) {
                this.adjacency()[i][j] = AdjacencyMatrixGraph.EDGE_NONE;
            }
        }
    }

    private void setNumberOfVertices(int newNumberOfVertices) {
        this._numberOfVertices = newNumberOfVertices;
    }

    public int numberOfVertices() {
        return this._numberOfVertices;
    }

    private void setNumberOfEdges(int newNumberOfEdges) {
        this._numberOfEdges = newNumberOfEdges;
    }

    public int numberOfEdges() {
        return this._numberOfEdges;
    }

    private void setAdjacency(int[][] newAdjacency) {
        this._adjacency = newAdjacency;
    }

    private int[][] adjacency() {
        return this._adjacency;
    }

    private boolean adjacencyOfEdgeDoesExist(int from, int to) {
        return (this.adjacency()[from][to] != AdjacencyMatrixGraph.EDGE_NONE);
    }

    public boolean vertexDoesExist(int aVertex) {
        return aVertex >= 0 && aVertex < this.numberOfVertices();
    }

    public boolean edgeDoesExist(int from, int to) {
        if (this.vertexDoesExist(from) && this.vertexDoesExist(to)) {
            return (this.adjacencyOfEdgeDoesExist(from, to));
        }

        return false;
    }

    public boolean addEdge(int from, int to) {
        if (this.vertexDoesExist(from) && this.vertexDoesExist(to)) {
            if (!this.adjacencyOfEdgeDoesExist(from, to)) {
                this.adjacency()[from][to] = AdjacencyMatrixGraph.EDGE_EXIST;
                this.adjacency()[to][from] = AdjacencyMatrixGraph.EDGE_EXIST;
                this.setNumberOfEdges(this.numberOfEdges() + 1);
                return true;
            }
        }

        return false;
    }

    public boolean removeEdge(int from, int to) {
        if (!this.vertexDoesExist(from) || !this.vertexDoesExist(to)) {
            if (this.adjacencyOfEdgeDoesExist(from, to)) {
                this.adjacency()[from][to] = AdjacencyMatrixGraph.EDGE_NONE;
                this.adjacency()[to][from] = AdjacencyMatrixGraph.EDGE_NONE;
                this.setNumberOfEdges(this.numberOfEdges() - 1);
                return true;
            }
        }
        return false;
    }

    public List<Integer> depthFirstOrder(int startVertex) {
        if (startVertex >= _numberOfVertices || startVertex < 0) {
            return new ArrayList<Integer>();
        }

        boolean[] visited = new boolean[_numberOfVertices];

        ArrayList<Integer> orderList = new ArrayList<Integer>();

        depthFirstOrder(startVertex, visited, orderList);

        return orderList;
    }

    private void depthFirstOrder(int currentVertex, boolean[] visited, List<Integer> orderList) {
        if (visited[currentVertex]) {
            return;
        }

        visited[currentVertex] = true;
        orderList.add(currentVertex);

        int[] adjacent = _adjacency[currentVertex];
        for (int i = 0; i < adjacent.length; i++) {
            if (adjacent[i] == AdjacencyMatrixGraph.EDGE_EXIST) {
                depthFirstOrder(i, visited, orderList);
            }
        }
    }

    public List<Integer> breadthFirstOrder(int startVertex) {
        if (startVertex >= _numberOfVertices || startVertex < 0) {
            return new ArrayList<Integer>();
        }

        boolean[] visited = new boolean[_numberOfVertices];

        ArrayList<Integer> orderList = new ArrayList<Integer>();

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            if (visited[currentVertex]) {
                continue;
            }

            orderList.add(currentVertex);
            visited[currentVertex] = true;

            int[] adjacent = _adjacency[currentVertex];
            for (int vertex = 0; vertex < adjacent.length; vertex++) { // vertex we are considering exploring, we add it to the queue // If an
                                                                       // edge exists between the current vertex and the
                if (adjacent[vertex] == AdjacencyMatrixGraph.EDGE_EXIST) {
                    queue.add(vertex);
                }
            }
        }

        return orderList;
    }

    public String toString() {
        String s = "    ";
        for (int i = 0; i < this.numberOfVertices(); i++) {
            s = s + i + " ";
        }
        s = s + " \n";

        for (int i = 0; i < this.numberOfVertices(); i++) {
            s = s + i + " : ";
            for (int j = 0; j < this.numberOfVertices(); j++) {
                s = s + this._adjacency[i][j] + " ";
            }
            s = s + "\n";
        }
        return s;
    }
}
