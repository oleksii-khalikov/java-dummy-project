package org.example.dynamicprogramming;

public class OptimalJobScheduling {

    private final int numberProcesses;
    private final int numberMachines;
    private final int[][] Run;
    private final int[][] Transfer;
    private final int[][] Cost;

    public OptimalJobScheduling(int numberProcesses, int numberMachines, int[][] Run, int[][] Transfer) {
        this.numberProcesses = numberProcesses;
        this.numberMachines = numberMachines;
        this.Run = Run;
        this.Transfer = Transfer;
        this.Cost = new int[numberProcesses][numberMachines];
    }

    public void execute() {
        this.calculateCost();
        this.showResults();
    }
    private void calculateCost() {

        for (int i = 0; i < numberProcesses; i++) { // for each Process

            for (int j = 0; j < numberMachines; j++) { // for each Machine

                Cost[i][j] = runningCost(i, j);
            }
        }
    }

    private int runningCost(int process, int machine) {

        if (process == 0)
            return Run[process][machine];
        else {

            int[] runningCosts = new int[numberMachines];

            for (int k = 0; k < numberMachines; k++)
                runningCosts[k] = Cost[process - 1][k] + Transfer[k][machine] + Run[process][machine]; // transferring the result to our Machine and executing
                                                                                                       // the Process to our Machine

            return findMin(runningCosts);
        }
    }
    private int findMin(int[] cost) {

        int min = 0;

        for (int i = 1; i < cost.length; i++) {

            if (cost[i] < cost[min]) min = i;
        }
        return cost[min];
    }

    private void showResults() {

        for (int i = 0; i < numberProcesses; i++) {

            for (int j = 0; j < numberMachines; j++) {
                System.out.print(Cost[i][j]);
                System.out.print(" ");
            }

            System.out.println();
        }
        System.out.println();
    }

    public int getCost(int process, int machine) {
        return Cost[process][machine];
    }
}
