package bg.softuni.advancedgraphs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PrimMSF {

    static class Node {

        private int name;
        private List<Edge> child;
        private boolean used;

        public Node(int name) {
            this.name = name;
            this.child = new ArrayList<>();
            setUsed(false);
        }

        public List<Edge> getChild() {
            return child;
        }

        public void setChild(List<Edge> child) {
            this.child = child;
        }

        public int getName() {
            return name;
        }

        public void setName(int name) {
            this.name = name;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }
    }

    static class Edge implements Comparable<Edge> {

        private Node startNode;
        private Node endNode;
        private int weight;

        public Edge(Node a, Node b, int weight) {

            this.startNode = a;
            this.endNode = b;
            this.weight = weight;
        }

        @Override
        public boolean equals(Object o) {
            Edge v = (Edge) o;
            return (this.startNode.equals(v.startNode) && this.endNode.equals(v.endNode) && this.weight == v.weight);
        }

        @Override
        public int compareTo(Edge o) {
            return weight > o.weight ? 1 : -1;
        }

        public Node getNodeA() {
            return startNode;
        }

        public void setNodeA(Node nodeA) {
            this.startNode = nodeA;
        }

        public Node getNodeB() {
            return endNode;
        }

        public void setNodeB(Node nodeB) {
            this.endNode = nodeB;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }

    private static List<Edge> result = new ArrayList<>();
    private static Node[] nodes = new Node[9];

    public static void main(String[] args) {

        createGraf();

        for (Node node : nodes) {
            prim(node);
        }

        printMSF();
    }

    private static void prim(Node node) {

        node.used = true;
        PriorityQueue<Edge> Q = new PriorityQueue<>();
        Q.addAll(node.child);
        while (!Q.isEmpty()) {
            Edge next = Q.remove();
            if (!next.startNode.used ^ !next.endNode.used) {

                result.add(next);
                Node n = next.startNode.used ? next.endNode : next.startNode;
                n.used = true;
                Q.addAll(n.child);
            }
        }

    }

    private static void printMSF() {

        for (Edge edge : result) {
            System.out.printf("(%d & %d) --> %d\n", edge.startNode.name, edge.endNode.name, edge.weight);
        }
    }

    private static void createGraf() {

        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i);
        }

        nodes[0].child.add(new Edge(nodes[0], nodes[1], 4));// AB
        nodes[0].child.add(new Edge(nodes[0], nodes[2], 5));// AC
        nodes[0].child.add(new Edge(nodes[0], nodes[3], 9));// AD
        nodes[1].child.add(new Edge(nodes[1], nodes[3], 2));// BD
        nodes[2].child.add(new Edge(nodes[2], nodes[3], 20));// CD
        nodes[2].child.add(new Edge(nodes[2], nodes[4], 7));// CE
        nodes[3].child.add(new Edge(nodes[3], nodes[4], 8));// DE
        nodes[4].child.add(new Edge(nodes[4], nodes[5], 12));// EF
        nodes[6].child.add(new Edge(nodes[6], nodes[7], 8));// GH
        nodes[6].child.add(new Edge(nodes[6], nodes[8], 10));// GI
        nodes[7].child.add(new Edge(nodes[7], nodes[8], 7));// HI

    }
}
