package main.java.com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;

// Implement adjacency list in graph
public class Graph {
    ArrayList<LinkedList<Node>> alist;

    public static class Node {
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    Graph() {
        alist = new ArrayList<>();
    }

    public void addNode(Node node) {
        System.out.println(" addNode " + node.data);
        LinkedList<Node> currentList = new LinkedList<>();
        currentList.add(node);
        alist.add(currentList);
    }

    public void addEdge(int src, int dst) {
        System.out.println("addEdge");
        LinkedList<Node> currentList = alist.get(src);
        Node dstNode = alist.get(dst).get(0);
        currentList.add(dstNode);
     }

    public boolean checkEdge(int src, int dst) {
        System.out.println("checkEdge " + src + "," + dst);
        LinkedList<Node> currentList = alist.get(src);
        Node dstNode = alist.get(dst).get(0);
        for (Node node : currentList) {
            if (node == dstNode) {
                return true;
            }
        }
        return false;
    }

    public void print() {
        for (LinkedList<Node> currentList : alist) {
            for (Node node : currentList) {
                System.out.print((char)node.data + " -> ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addNode(new Node('A'));
        graph.addNode(new Node('B'));
        graph.addNode(new Node('C'));
        graph.addNode(new Node('D'));
        graph.addNode(new Node('E'));

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