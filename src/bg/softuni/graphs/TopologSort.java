package bg.softuni.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class TopologSort {

    static class Node {

        private int name;
        private ArrayList<Node> edge;

        public Node(int Name) {

            this.name = Name;
            this.edge = new ArrayList<>();
        }

        public int getName() {
            return name;
        }

        public void setName(int name) {
            this.name = name;
        }

        public ArrayList<Node> getEdge() {
            return edge;
        }

        public void setEdge(ArrayList<Node> edge) {
            this.edge = edge;
        }
    }

    private static ArrayList<Node> graf = createGraf();
    private static List<Node> result = new LinkedList<>();
    private static HashSet<Node> visited = new HashSet<>();
    private static HashSet<Node> cicle = new HashSet<>();
    private static boolean iscicle = false;

    public static void main(String[] args) {

        for (Node node : graf) {
            topSortDFS(node);
            if (iscicle)
                break;
        }

        if (!iscicle) {
            for (Node node : result) {
                System.out.print(node.getName() + " -> ");
            }
        } else {
            System.out.println("ERROR: Cicle detected");
        }
    }

    private static void topSortDFS(Node node) {

        if (cicle.contains(node)) {
            iscicle = true;
            return;
        }

        if (!visited.contains(node)) {

            visited.add(node);
            cicle.add(node);
            for (Node n : node.edge) {
                topSortDFS(n);
            }
            cicle.remove(node);
            result.add(0, node);
        }
    }

    private static ArrayList<Node> createGraf() {

        ArrayList<Node> Graf = new ArrayList<>();

        Node zero = new Node(0);
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);

        four.edge.add(zero);
        four.edge.add(one);
        zero.edge.add(three);
        zero.edge.add(five);
        three.edge.add(five);
        five.edge.add(one);
        five.edge.add(two);
        one.edge.add(two);

        Graf.add(zero);
        Graf.add(one);
        Graf.add(two);
        Graf.add(three);
        Graf.add(four);
        Graf.add(five);

        return Graf;
    }

}
