package org.example.sorts;

import java.util.*;

public class TopologicalSort {

    private enum Color {
        WHITE, GRAY, BLACK,
    }

    private static class Vertex {

        public final String label;

        public Color color = Color.WHITE;

        public final ArrayList<String> next = new ArrayList<>();

        public Vertex(String label) {
            this.label = label;
        }
    }

    static class Graph {

        private final HashMap<String, Vertex> adj = new LinkedHashMap<>();

        public void addEdge(String label, String... next) {
            adj.put(label, new Vertex(label));
            if (!next[0].isEmpty()) Collections.addAll(adj.get(label).next, next);
        }
    }

    static class BackEdgeException extends RuntimeException {

        public BackEdgeException(String backEdge) {
            super("This graph contains a cycle. No linear ordering is possible. " + backEdge);
        }
    }

    public static LinkedList<String> sort(Graph graph) {
        LinkedList<String> list = new LinkedList<>();
        graph.adj.forEach((name, vertex) -> {
            if (vertex.color == Color.WHITE) {
                list.addFirst(sort(graph, vertex, list));
            }
        });
        return list;
    }

    private static String sort(Graph graph, Vertex u, LinkedList<String> list) {
        u.color = Color.GRAY;
        graph.adj.get(u.label).next.forEach(label -> {
            if (graph.adj.get(label).color == Color.WHITE) {
                list.addFirst(sort(graph, graph.adj.get(label), list));
            } else if (graph.adj.get(label).color == Color.GRAY) {
                throw new BackEdgeException("Back edge: " + u.label + " -> " + label);
            }
        });
        u.color = Color.BLACK;
        return u.label;
    }
}
