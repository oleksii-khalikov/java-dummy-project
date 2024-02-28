package org.example.searches;

import org.example.datastructures.Node;

import java.util.*;

public class BreadthFirstSearch<T> {

    private final List<T> visited = new ArrayList<>();

    public Optional<Node<T>> search(final Node<T> node, final T value) {
        if (node == null) {
            return Optional.empty();
        }
        if (node.getValue().equals(value)) {
            visited.add(value);
            return Optional.of(node);
        }
        visited.add(node.getValue());

        Queue<Node<T>> queue = new ArrayDeque<>(node.getChildren());

        while (!queue.isEmpty()) {
            final Node<T> current = queue.poll();
            visited.add(current.getValue());

            if (current.getValue().equals(value)) {
                return Optional.of(current);
            }

            queue.addAll(current.getChildren());
        }

        return Optional.empty();
    }

    public List<T> getVisited() {
        return visited;
    }
}
