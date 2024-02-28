package org.example.datastructures.graphs;

import java.util.ArrayList;

class Cycle {

    private int nodes, edges;
    private int[][] adjacencyMatrix;
    private boolean[] visited;
    ArrayList<ArrayList<Integer>> cycles = new ArrayList<ArrayList<Integer>>();


    public void start() {
        for (int i = 0; i < nodes; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            dfs(i, i, temp);
            for (int j = 0; j < nodes; j++) {
                adjacencyMatrix[i][j] = 0;
                adjacencyMatrix[j][i] = 0;
            }
        }
    }

    private void dfs(Integer start, Integer curr, ArrayList<Integer> temp) {
        temp.add(curr);
        visited[curr] = true;
        for (int i = 0; i < nodes; i++) {
            if (adjacencyMatrix[curr][i] == 1) {
                if (i == start) {
                    cycles.add(new ArrayList<Integer>(temp));
                } else {
                    if (!visited[i]) {
                        dfs(start, i, temp);
                    }
                }
            }
        }

        if (temp.size() > 0) {
            temp.remove(temp.size() - 1);
        }
        visited[curr] = false;
    }

    public void printAll() {
        for (int i = 0; i < cycles.size(); i++) {
            for (int j = 0; j < cycles.get(i).size(); j++) {
                System.out.print(cycles.get(i).get(j) + " -> ");
            }
            System.out.println(cycles.get(i).get(0));
            System.out.println();
        }
    }
}


