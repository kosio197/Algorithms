package bg.softuni.advancedgraphs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KruskalMSF {

    static class Node {

        private int name;
        private Node parent;

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public Node(int name) {
            this.name = name;
            this.parent = null;
        }

        public int getName() {
            return name;
        }

        public void setName(int name) {
            this.name = name;
        }
    }

    static class Edge implements Comparable<Edge> {

        private Node nodeA;
        private Node nodeB;
        private int weight;

        public Edge(Node a, Node b, int weight) {

            this.nodeA = a;
            this.nodeB = b;
            this.weight = weight;
        }

        @Override
        public boolean equals(Object o) {
            Edge v = (Edge) o;
            return (this.nodeA.equals(v.nodeA) && this.nodeB.equals(v.nodeB) && this.weight == v.weight);
        }

        @Override
        public int compareTo(Edge o) {
            return weight > o.weight ? 1 : -1;
        }

        public Node getNodeA() {
            return nodeA;
        }

        public void setNodeA(Node nodeA) {
            this.nodeA = nodeA;
        }

        public Node getNodeB() {
            return nodeB;
        }

        public void setNodeB(Node nodeB) {
            this.nodeB = nodeB;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }

    private static Node[] nodes = new Node[9];
    private static PriorityQueue<Edge> orderedEgge = new PriorityQueue<>();

    public static void main(String[] args) {

        List<Edge> forest = creatForest();
        orderedEgge.addAll(forest);

        List<Edge> result = kruskal();

        for (Edge edge : result) {
            System.out.printf("%d%d = %d  ", edge.nodeA.name, edge.nodeB.name, edge.weight);
        }
    }

    private static List<Edge> kruskal() {
        List<Edge> result = new ArrayList<>();
        while (!orderedEgge.isEmpty()) {
            Edge e = orderedEgge.remove();
            e.nodeA.parent = findRoot(e.nodeA);
            e.nodeB.parent = findRoot(e.nodeB);
            if (!e.nodeA.parent.equals(e.nodeB.parent)) {

                e.nodeB.parent = e.nodeA;
                result.add(e);
            }
        }

        return result;
    }

    private static Node findRoot(Node n) {

        Node root = n;
        while (root.name != root.parent.name) {
            root = root.parent;
        }

        return root;
    }

    private static List<Edge> creatForest() {

        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i);
            nodes[i].parent = nodes[i];
        }

        ArrayList<Edge> forest = new ArrayList<>();

        forest.add(new Edge(nodes[0], nodes[1], 4));// AB
        forest.add(new Edge(nodes[0], nodes[2], 5));// AC
        forest.add(new Edge(nodes[0], nodes[3], 9));// AD
        forest.add(new Edge(nodes[1], nodes[3], 2));// BD
        forest.add(new Edge(nodes[2], nodes[3], 20));// CD
        forest.add(new Edge(nodes[2], nodes[4], 7));// CE
        forest.add(new Edge(nodes[3], nodes[4], 8));// DE
        forest.add(new Edge(nodes[4], nodes[5], 12));// EF
        forest.add(new Edge(nodes[6], nodes[7], 8));// GH
        forest.add(new Edge(nodes[6], nodes[8], 10));// GI
        forest.add(new Edge(nodes[7], nodes[8], 7));// HI

        return forest;
    }
}
