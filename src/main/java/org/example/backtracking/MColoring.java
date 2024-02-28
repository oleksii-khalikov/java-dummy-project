package org.example.backtracking;

import java.util.*;

class Node {
    int color = 1;
    Set<Integer> edges = new HashSet<Integer>();
}

public class MColoring {
    static int possiblePaint(ArrayList<Node> nodes, int n, int m) {

        ArrayList<Integer> visited = new ArrayList<Integer>();
        for (int i = 0; i < n + 1; i++) {
            visited.add(0);
        }

        int maxColors = 1;

        for (int sv = 1; sv <= n; sv++) {
            if (visited.get(sv) > 0) {
                continue;
            }

            visited.set(sv, 1);
            Queue<Integer> q = new LinkedList<>();
            q.add(sv);

            while (q.size() != 0) {
                int top = q.peek();
                q.remove();

                for (int it : nodes.get(top).edges) {

                    if (nodes.get(top).color == nodes.get(it).color) {
                        nodes.get(it).color += 1;
                    }

                    maxColors = Math.max(maxColors, Math.max(nodes.get(top).color, nodes.get(it).color));
                    if (maxColors > m) return 0;

                    if (visited.get(it) == 0) {
                        visited.set(it, 1);
                        q.add(it);
                    }
                }
            }
        }
        return 1;
    }
}

