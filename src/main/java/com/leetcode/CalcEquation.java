package main.java.com.leetcode;

import java.util.*;

// 399 Graph - directed weighed
public class CalcEquation {
    public static class Edge {
        String destination;
        double weight;

        Edge(String destination, double weight) {
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "(" + destination + "," + weight + ")";
        }
    }
    public static class Graph {
        Map<String, List<Edge>> adjacencyList;
        Set<String> variables;
        int numberOfNode;

        Graph(int n) {
            adjacencyList = new HashMap<>();
            variables = new HashSet<>();
            numberOfNode = n;
        }

        public void addAdjacencyList(String s, List<Edge> weightDestination) {
            adjacencyList.put(s, weightDestination);
        }

        public void printGraph() {
            Map<String, List<Edge>> list = adjacencyList;
            for (String node : list.keySet()) {
                System.out.print(node + "  ->");
                List<Edge> edges = list.get(node);
                for (Edge edge : edges) {
                    System.out.print(edge + " " + " ");
                }
                System.out.println();
            }
        }

        public void addEdge(String s, Edge weightedEdge) {
            List<Edge> current = adjacencyList.get(s);
            current.add(weightedEdge);
        }

        public void addReversedEdge(String s, Edge weightedEdge) {
            List<Edge> current = adjacencyList.get(s);
            current.add(weightedEdge);
        }

        public double checkEdge(String source, String destination, Set<String> visited) {
            if (source.equals(destination))
                return 1;

            visited.add(source);

            List<Edge> currentList = adjacencyList.get(source);
            if (currentList != null) {
                for (Edge edge : currentList) {
                    if (!visited.contains(edge.destination)) {
                        double weightThroughEdge = checkEdge(edge.destination, destination, visited);
                        if (weightThroughEdge != -1) {
                            return edge.weight * weightThroughEdge;
                        }
                    }
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        String[][] eStrings = new String [][] {{"a", "b"}, {"b", "c"}};
        double[] values = new double [] {2.0, 3.0};
        String[][] qStrings = new String [][] {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};

        List<List<String>> equations = new ArrayList<>();
        for (int i=0; i<eStrings.length; i++) {
            List<String> equation = new ArrayList<>();
            equation.add(eStrings[i][0]);
            equation.add(eStrings[i][1]);
            equations.add(equation);
        }

        List<List<String>> queries = new ArrayList<>();
        for (int i=0; i< qStrings.length; i++) {
            List<String> query = new ArrayList<>();
            query.add(qStrings[i][0]);
            query.add(qStrings[i][1]);
            queries.add(query);
        }

//        System.out.println(" equations " + equations);
//        System.out.println(" values " + Arrays.toString(values));
//        System.out.println(" queries " + queries);

        double[] result = calcEquation(equations, values, queries);
        System.out.println("calcEquation " + Arrays.toString(result));
    }

    public static double[] calcEquation(List<List<String>> equations, double[] values,
                                        List<List<String>> queries) {

        Set<String> variableSet = new HashSet<>();
        for (List<String> equation : equations) {
            variableSet.add(equation.get(0));
            variableSet.add(equation.get(1));
        }

        Graph graph = new Graph(variableSet.size());
        for (String variable : variableSet) {
            graph.addAdjacencyList(variable, new ArrayList<>());
        }

        for (int i=0; i<equations.size(); i++) {
            String s = equations.get(i).get(0);
            String d = equations.get(i).get(1);
            if (graph.adjacencyList.containsKey(s)) {
                Edge edge = new Edge(d, values[i]);
                double reciprocal = 1/values[i];
                Edge reversedEdge = new Edge(s, reciprocal);
                graph.addEdge(s, edge);
                graph.addReversedEdge(d, reversedEdge);
            }
        }

        double[] result = new double[queries.size()];
        for (int i=0; i<queries.size(); i++) {
            String s = queries.get(i).get(0);
            String d = queries.get(i).get(1);
            if (graph.adjacencyList.containsKey(s) && graph.adjacencyList.containsKey(d)) {
                Set<String> visited = new HashSet<>();
                result[i] = graph.checkEdge(s,d, visited);
            } else {
                result[i] = -1;
            }
        }
        return result;
     }
}
