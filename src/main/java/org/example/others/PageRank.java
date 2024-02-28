package org.example.others;


class PageRank {
    public int[][] path = new int[10][10];
    public double[] pagerank = new double[10];

    public void calc(double totalNodes) {
        double InitialPageRank;
        double OutgoingLinks = 0;
        double DampingFactor = 0.85;
        double[] TempPageRank = new double[10];
        int ExternalNodeNumber;
        int InternalNodeNumber;
        int k = 1;
        int ITERATION_STEP = 1;
        InitialPageRank = 1 / totalNodes;
        for (k = 1; k <= totalNodes; k++) {
            this.pagerank[k] = InitialPageRank;
        }

        for (k = 1; k <= totalNodes; k++) {
            System.out.printf(" Page Rank of " + k + " is :\t" + this.pagerank[k] + "\n");
        }

        while (ITERATION_STEP <= 2) {
            for (k = 1; k <= totalNodes; k++) {
                TempPageRank[k] = this.pagerank[k];
                this.pagerank[k] = 0;
            }

            for (InternalNodeNumber = 1; InternalNodeNumber <= totalNodes; InternalNodeNumber++) {
                for (ExternalNodeNumber = 1; ExternalNodeNumber <= totalNodes; ExternalNodeNumber++) {
                    if (this.path[ExternalNodeNumber][InternalNodeNumber] == 1) {
                        k = 1;
                        OutgoingLinks = 0;
                        while (k <= totalNodes) {
                            if (this.path[ExternalNodeNumber][k] == 1) {
                                OutgoingLinks = OutgoingLinks + 1;
                            }
                            k = k + 1;
                        }
                        this.pagerank[InternalNodeNumber] += TempPageRank[ExternalNodeNumber] * (1 / OutgoingLinks);
                    }
                }
                System.out.printf("\n After " + ITERATION_STEP + "th Step \n");

                for (k = 1; k <= totalNodes; k++) {
                    System.out.printf(" Page Rank of " + k + " is :\t" + this.pagerank[k] + "\n");
                }

                ITERATION_STEP = ITERATION_STEP + 1;
            }

            for (k = 1; k <= totalNodes; k++) {
                this.pagerank[k] = (1 - DampingFactor) + DampingFactor * this.pagerank[k];
            }

            System.out.print("\n Final Page Rank : \n");
            for (k = 1; k <= totalNodes; k++) {
                System.out.printf(" Page Rank of " + k + " is :\t" + this.pagerank[k] + "\n");
            }
        }
    }
}
