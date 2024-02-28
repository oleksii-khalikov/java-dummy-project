package org.example.datastructures.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class TarjansAlgorithm {

    private int Time;

    private List<List<Integer>> SCClist = new ArrayList<List<Integer>>();

    public List<List<Integer>> stronglyConnectedComponents(int V, List<List<Integer>> graph) {


        int[] lowTime = new int[V];
        int[] insertionTime = new int[V];
        for (int i = 0; i < V; i++) {
            insertionTime[i] = -1;
            lowTime[i] = -1;
        }

        boolean[] isInStack = new boolean[V];

        Stack<Integer> st = new Stack<Integer>();

        for (int i = 0; i < V; i++) {
            if (insertionTime[i] == -1) stronglyConnCompsUtil(i, lowTime, insertionTime, isInStack, st, graph);
        }

        return SCClist;
    }

    private void stronglyConnCompsUtil(int u, int[] lowTime, int[] insertionTime, boolean[] isInStack, Stack<Integer> st, List<List<Integer>> graph) {

        insertionTime[u] = Time;
        lowTime[u] = Time;
        Time += 1;

        isInStack[u] = true;
        st.push(u);

        for (Integer vertex : graph.get(u)) {
            if (insertionTime[vertex] == -1) {
                stronglyConnCompsUtil(vertex, lowTime, insertionTime, isInStack, st, graph);
                lowTime[u] = Math.min(lowTime[u], lowTime[vertex]);
            } else if (isInStack[vertex]) {
                lowTime[u] = Math.min(lowTime[u], insertionTime[vertex]);
            }
        }
        if (lowTime[u] == insertionTime[u]) {
            int w = -1;
            var scc = new ArrayList<Integer>();

            while (w != u) {
                w = st.pop();
                scc.add(w);
                isInStack[w] = false;
            }
            SCClist.add(scc);
        }
    }
}
