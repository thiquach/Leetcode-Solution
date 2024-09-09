package main.java.com.leetcode;

public class GraphByMatrix {
    boolean[][] adjacencyMatrix;
    int numberOfVertices;

    GraphByMatrix(int n) {
        numberOfVertices = n;
        adjacencyMatrix = new boolean[n][n];
    }

    public void addEdge(int src, int dst) {
        System.out.println("addEdge " + src + ", " + dst);
        adjacencyMatrix[src][dst] = true;
        adjacencyMatrix[dst][src] = true;
    }

    public boolean checkEdge(int src, int dst) {
        System.out.println("checkEdge " + src + "," + dst);
        return adjacencyMatrix[src][dst];
    }

    public void print() {
        for (int i = 0; i < numberOfVertices; i++) {
            for (int j = 0; j < numberOfVertices; j++) {
                System.out.print(
                        adjacencyMatrix[i][j] ? "1 " : "0 ");
            }
            System.out.println();
            }
    }

    public static void main(String[] args) {
        int n = 5;
        GraphByMatrix graph = new GraphByMatrix(n);

        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(2,3);
        graph.addEdge(2,4);
        graph.addEdge(4,0);
        graph.addEdge(4,2);

        graph.print();

        System.out.println("A to D -> " + graph.checkEdge(0,1));
    }
}
